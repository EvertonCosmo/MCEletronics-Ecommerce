<template>
  <div>
    <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
    <!-- <NavBar></NavBar> -->
    <header>
      <b-navbar toggleable="lg" type="dark" class="box-search">
        <b-navbar-toggle target="nav_collapse"/>
        <router-link to="/">
          <b-navbar-brand
            style="font-size: 100%;color: white"
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
                    placeholder="Buscar... "
                    v-model="search.text"
                    @input="search_text()"
                  />

                
                    <i class="fas fa-search"
                    style=" 
                      position:absolute;
                      right:1%;
                      top: 15%;
                      color: #033076;
                      font-size:75%;
                      cursor:pointer"
                  ></i>
                 
                </b-input-group>
              </b-form-group>
            </b-nav-form>
          </div>

          <div style="max-width: 25rem; width: 100%; display: block">
            <!-- <router-link :to="{path:'/'}">
            
                <i id="button-favorites" class="far fa-heart"></i>
              
            </router-link> -->
            <router-link :to="{name:'bag'}">
          
                <i id="button-bag" class="fas fa-shopping-cart">
                 
                    <b-badge v-if="hasProduct()" variant="primary">{{ getProductsInCart.length }}</b-badge>
                  
                </i>
            
            </router-link>

            <router-link :to="{name:'login'}" v-if="!logged">
              <b-button id="button-user">
                Entrar
              </b-button>
            </router-link>
           
       
      <div id="navbarDropdownMenuLinkParent" v-if="logged" >
  <b-dropdown id="dropdown-buttons" :text=user.username class="m-2"  no-caret >
    <b-dropdown-item-button >
       <router-link :to="{name:'dashboard'}" >
               <i class="fa fa-user-circle"></i> 
               Perfil
            </router-link>
      
      </b-dropdown-item-button>

    <b-dropdown-item-button ><i class="fas fa-cog"></i> Configurações </b-dropdown-item-button>
     <b-dropdown-item-button ><i class="fas fa-sign-out-alt"></i> Logout</b-dropdown-item-button>
  </b-dropdown>
</div>
            
<!-- 
            <router-link :to="{name:'dashboard'}" v-if="logged">
                <i class="fas fa-user-circle" style="margin-right: : 40%">
                  <span style="font-size: 60%">{{user.username}}</span>
                </i>
            </router-link>
              <b-button id="button-user-logout"  v-if="logged" @click="logout">
                 Sair
              </b-button> -->
          </div>
        </b-collapse>
      </b-navbar>
    </header>
  </div>
</template>

<script>
/* eslint-disable */

import { mapState, mapActions, mapMutations, mapGetters } from "vuex";
import api from "../../services/api";
export default {
  name: "PageHome",


  data() {
    return {
      titlePage: "MC Eletronics",
      logged: false,
      user: {},
      search:{
        text:''
      }
    };
  },

  computed: {
    ...mapGetters(["getProductsInCart"]),
    ...mapState({ products: state => state.products.products})
  },

  methods: {
    search_text(){
      console.log(this.search.text)

    },
    hasProduct() {
      return this.getProductsInCart.length > 0;
    },

    logout() {
      this.$session.destroy();

      this.logged = false; // not logged
      location.reload();
    }
  },
  created() {
    if (this.$session.exists()) {
      this.logged = true; // logged
      this.user = JSON.parse(this.$session.get("user"));
    }
  }
};
</script>

<style scoped>
#navbarDropdownMenuLinkParent{ 
  float:right; 
  color:#fff;
  width:50%;
  font-size: 70%;
  margin-right: 0%;
  margin-left:-12%;
  margin-top:1%;
  font-size:65%
}
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
  margin-top: 2%;
  
}

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
  line-height: 1.2;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
    Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", sans-serif;
  font-weight: normal;
  /* color: rgba(0, 0, 0, 0.87); */
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
  margin-top: 2.7%;
}

#button-favorites {
  background-color: #033076;
  color:#fff;
  width: 10%;
  font-size: 55%;
  border: 0px;
  margin-left: 8%;
  border-radius: 5%;
}
#button-bag {
  background-color: #033076;
  color:#fff;
  width: 10%;
  height: 70%;
  font-size: 54%;
  border: 0px;
  margin-left: 8%;
}

.navigation {
  width: 100%;
  margin-top: -0.5%;
}
#button-user {
  background-color: #ffff;
  color:#033076;
  width: 50%;
  /* height: 10%; */
  font-size: 70%;
  /* border:2%; */
  margin-left: 10%;
  border-radius: 25px ;
}
#button-user-logout{
  background-color: #ffff;
  color:#033076;
  width: 20%;
  /* height: 10%; */
  font-size: 70%;
  /* border:2%; */
  margin-left: 10%;
  border-radius: 25px ;
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

