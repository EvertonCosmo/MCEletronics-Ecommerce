<template>
  <div>
    <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
    <!-- <NavBar></NavBar> -->
    <header>
      <b-navbar toggleable="lg" type="dark" class="box-search">
        <b-navbar-toggle target="nav_collapse"/>
        <router-link to="/">
          <b-navbar-brand
            style="font-size: 90%; position: relative; color: white"
            class="logo"
          >{{titlePage}}</b-navbar-brand>
        </router-link>
        <b-collapse e is-nav style="width: 100%" id="nav_collapse">
          <div class="navigation">
            <b-nav-form>
              <b-form-group id="form-search">
                <b-input-group>
                  <b-form-input
                    style="border-radius: 6px; z-index: 0"
                    maxlength="10"
                    name="search"
                    placeholder="Buscar... "
                  />
                  <button style=" position:absolute; 
                            border: none; 
                            width: 5%; 
                            margin-top: 1.3%; 
                            right:2%; 
                            background: #fff; 
                            z-index: 1;">
                    <i class="fas fa-search"
                    style=" 
                      position:absolute;
                      right:2.0%;
                      top: 25%;
                      color: #033076; 
                      font-size:60%"
                  ></i>
                  </button>
                  
                </b-input-group>
              </b-form-group>
            </b-nav-form>
          </div>

          <div style="max-width: 25rem; width: 100%; display: block">
            <router-link :to="{path:'/'}">
              <b-button id="button-favorites">
                <i class="far fa-heart"></i>
              </b-button>
            </router-link>
            <router-link :to="{name:'bag'}">
              <b-button id="button-bag">
                <i class="fas fa-shopping-cart">
                  <span class="ml-1" v-if="hasProduct()">
                    <b-badge variant="primary">{{ getProductsInCart.length }}</b-badge>
                  </span>
                </i>
              </b-button>
            </router-link>

            <!-- <ul>
            <li class="nav-item dropdown" v-if="logged">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdownMenuLink"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >{{this.loggedUser.username}}</a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <router-link to="/" class="dropdown-item">Perfil</router-link>
                
                <router-link
                  :to="{name:'/'}"
                  class="dropdown-item text-danger"
                  @click.native="logout"
                >Logout</router-link>
              </div>
            </li>

            -->

            <!-- <i class="fas fa-user-circle "></i>Login  -->

            <router-link :to="{name:'login'}" v-if="!logged">
              <b-button id="button-user">
                <!-- <i class="fas fa-user-circle"></i> -->
                Entrar
              </b-button>
            </router-link>

            <router-link :to="{name:'dashboard'}" v-if="logged">
              <b-button id="button-user">
                <i class="fas fa-user-circle" style="margin-right: : 40%">
                  <span style="font-size: 60%">{{user.username}}</span>
                </i>
              </b-button>

              <b-button id="button-user" v-if="logged" @click="logout">
                <span style="font-size: 90%;">Sair</span>
              </b-button>
            </router-link>

            <!-- </ul> -->
            <!-- <router-link :to="{name:'login'}">

            
              
           
            </b-button>
            </router-link>-->
          </div>
        </b-collapse>
      </b-navbar>
    </header>

    <!-- <div>
      <b-navbar toggleable="lg" type="dark" variant="info">
        

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          
          <b-navbar-nav class="ml-auto">
            <b-navbar-brand style="margin-left: 0%" href="#">Home</b-navbar-brand>
            <b-navbar-brand style="margin-left: 2%" href="#">Sobre</b-navbar-brand>
            <b-navbar-brand style="margin-left: 0%" href="#">Contato</b-navbar-brand>
            <b-navbar-brand style="margin-left: 0%" href="#">Quem somos?</b-navbar-brand>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div> -->

    <div>
  <b-navbar style="height: 60px; margin-top: 2%; margin-bottom: 2%" toggleable="sm" type="light" variant="light">
    <b-navbar-toggle target="nav-text-collapse"></b-navbar-toggle>

      <div v-show="category">
          <b-dropdown
            id="dropdown-header"
            text="Categorias"
            class="m-2"
            variant="primary"
            size="lg"
          >
            <b-dropdown-header id="dropdown-header-1">Placas</b-dropdown-header>
            <b-dropdown-group id="Placas" header="Placas">
              <b-dropdown-item-button>Arduino</b-dropdown-item-button>
              <b-dropdown-item-button>Raspberry</b-dropdown-item-button>
            </b-dropdown-group>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-group id="dropdown-group-2" header="Shields">
              <b-dropdown-header>Shields</b-dropdown-header>
              <b-dropdown-item-button>Wifi</b-dropdown-item-button>
              <b-dropdown-item-button>Bluetooth</b-dropdown-item-button>
            </b-dropdown-group>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-group id="dropdown-group-2" header="Computadores">
              <b-dropdown-header>Computadores</b-dropdown-header>
              <b-dropdown-item-button>Pessoal</b-dropdown-item-button>
              <b-dropdown-item-button>Notebooks</b-dropdown-item-button>
            </b-dropdown-group>
          </b-dropdown>
        </div>

    

    <b-collapse id="nav-text-collapse" is-nav>
      <b-navbar-nav style="margin-left: 25%">
        <b-nav-text style="margin-left: 50%" >Home</b-nav-text>
        <b-nav-text style="margin-left: 50%" >Sobre</b-nav-text>
        <b-nav-text style="margin-left: 50%" >Contato</b-nav-text>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
  </div>
</template>

<script>
/* eslint-disable */

import { mapState, mapActions, mapMutations, mapGetters } from "vuex";
import { isLoggedIn, getLoggedInUser } from "../../services/authService";
import api from "../../services/api";
export default {
  name: "PageHome",
  props: {
    category: Boolean
  },

  data() {
    return {
      titlePage: "MCEletronics",
      logged: false,
      user: {}
    };
  },

  computed: {
    ...mapGetters(["getProductsInCart"])
    // ...mapState({
    //     loggedUser: state => state.users.loggedUser
    // })
  },

  methods: {
    //  ... mapActions(['addLoggedUser']),

    // ...mapMutations(["ADD_LOGGED_USER"]),

    hasProduct() {
      return this.getProductsInCart.length > 0;
    },

    //  isLogged(){
    //    return isLoggedIn()
    //  },

    logout() {
      // localStorage.removeItem("_auth")
      // this.$router.push("/");
      // location.reload();
      this.$session.destroy();

      this.logged = false; // not logged
      location.reload();
    }
  },
  created() {
    // const loggedUser = getLoggedInUser();
    // this.ADD_LOGGED_USER(loggedUser);
    // console.log(this.loggedUser)
    if (this.$session.exists()) {
      this.logged = true; // logged
      this.user = JSON.parse(this.$session.get("user"));
    }
  }

  // computed: mapState(["cartProducts"]),
};
</script>

<style scoped>
img {
  width: 50%;
}
body {
  font-family: Arial, Helvetica, sans-serif;
}
article {
  float: right;
  padding: 20px;
  width: 70%;
  background-color: #fff;
  height: 100px; /* only for demonstration, should be removed */
}
/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
  height: 100px;
}
/* Style the footer */

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav,
  article {
    width: 100%;
    height: auto;
  }
}
.more-sold {
  margin: 1%;
  background-color: rgb(222, 224, 224);
  height: 400px;
}

/* Create two columns/boxes that floats next to each other */
#categories {
  float: left;
  width: 30%;
  background: white;
  padding: 1.7%;
  font-size: 100%;
}

.logo {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
/*ver {
  background-color: #033076;
  border-radius: 8px;
  color: white;
}*/
.card-list {
  margin-top: auto;
  margin-left: auto;
}
.card {
  border: none;
}
.item {
  width: 100%;
  padding: 5%;
  border-left: none;
  border-right: none;
}
.item > :hover {
  /* Background-color: #033076; */
  background-color: #033076;
  color: white;
}
nav {
  line-height: 1.5;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
    Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", sans-serif;
  font-weight: normal;
  color: rgba(0, 0, 0, 0.87);
}
nav .brand-logo {
  position: absolute;
  color: #fff;
  display: inline-block;
  font-size: 2.1rem;
  padding: 0;
}
nav .brand-logo.center {
  left: 50%;
  -webkit-transform: translateX(-50%);
  transform: translateX(-50%);
}
.nav-wrapper {
  background: linear-gradient(-90deg, #033076);
  box-shadow: 1px 2px 2px 2px #033076;
  height: 4rem;
  width: 100%;
  margin-bottom: 10px;
  /* margin:auto; */
}
@media only screen and (max-width: 992px) {
  nav .brand-logo {
    left: 50%;
    -webkit-transform: translateX(-50%);
    transform: translateX(-50%);
  }
}
.logo {
  color: white;

  text-decoration: none;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 2.3rem;
  margin-left: 10px;
}

/* Style the header */
header {
  background-color: #033076;
  text-align: center;
  font-size: 35px;
  color: white;
  height: 2%;
}

article {
  float: right;
  padding: 20px;
  width: 70%;
  background-color: #fff;
  height: 100px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */

/* Style the footer */

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav,
  article {
    width: 100%;
    height: auto;
  }
}

/* Create two columns/boxes that floats next to each other */

#form-search {
  width: 100%;
  margin-top: 1.7%;
}

#button-favorites {
  background-color: #033076;
  width: 10%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 8%;
  border-radius: 5%;
}
#button-bag {
  background-color: #033076;
  width: 10%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 8%;
}
#purchase-value {
  color: white;
  font-size: 55%;
  margin-left: 10%;
}
.navigation {
  width: 100%;
  margin-top: -0.5%;
}
#button-user {
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 70%;
  border: 0px;
  margin-left: 10%;
  border-radius: 8%;
}

.box-search {
  position: sticky;
  width: 100%;
}

.logo {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
.item {
  width: 100%;
  /* padding:5%; */
  border-left: none;
  border-right: none;
}
.item > :hover {
  background-color: #033076;
  color: white;
}

* {
  box-sizing: border-box;
}
</style>

