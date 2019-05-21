<template>
    <div >
      <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
        <!-- <NavBar></NavBar> -->
     <header >   
      <b-navbar toggleable="lg" type="dark"  class="box-search">

        <b-navbar-toggle target="nav_collapse" />
        <router-link to="/">
          <b-navbar-brand style="font-size: 90%; position: relative; color: white" class="logo">
            {{titlePage}}
          </b-navbar-brand>
        </router-link>
        <b-collapse  e is-nav style="width: 100%" id="nav_collapse">
        
          <div class="navigation">
            <b-nav-form>
              <b-form-group id="form-search">
                <b-input-group >
                  <b-form-input style="border-radius: 6px; z-index: 0" maxlength="10" name="search"  placeholder="Buscar... "/>

                           
                           <i class="fas fa-search" style=" z-index: 1; position:absolute;right:2%;top: 25%;visibility:visible; color: #033076; font-size:50%" ></i>
                  
                   
                

                </b-input-group>    
                       
              </b-form-group>
            </b-nav-form> 
          </div>


          <div style="max-width: 25rem; width: 100%; display: block">
            <router-link :to="{path:'/'}">
            <b-button  id="button-favorites"> 
              <i class="far fa-heart"></i>
            </b-button>
            </router-link>
            <router-link :to  ="{name:'bag'}">
                <b-button id="button-bag" >
                   <i class="fas fa-shopping-cart">
               
                         <span class="ml-1" v-if="hasProduct()"> <b-badge variant="primary">{{ getProductsInCart.length }}</b-badge></span>

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
           <router-link :to="{name:'login'}" v-if="logged">

            <b-button id="button-user" v-if="logged" @click="logout">
             <!-- <i class="fas fa-user-circle"> </i> -->
            Sair
            </b-button>
          </router-link>

          
          <!-- </ul> -->
           <!-- <router-link :to="{name:'login'}">

            
              
           
            </b-button>
          </router-link> -->
           
          </div>
       
        


        </b-collapse>
        
      </b-navbar>
     </header>
  <!-- <b-card-group> -->
      <!-- <b-card style= "background-color:red">  -->
          <!-- <b-list-group style="max-width:23rem">
            <b-list-group-item active><i class="fas fa-list-ul"></i> Categorias</b-list-group-item>
              <b-list-group-item href="#some-link">Raspberry PI</b-list-group-item>
              <b-list-group-item href="#some-link">Computadores</b-list-group-item>
              <b-list-group-item href="#some-link">Componentes</b-list-group-item>
              <b-list-group-item href="#some-link">Celulares</b-list-group-item>
              <b-list-group-item href="#some-link">Arduíno</b-list-group-item>
              <b-list-group-item href="#some-link">Conexões</b-list-group-item>
              <b-list-group-item href="#some-link">Shields</b-list-group-item>
              <b-list-group-item href="#some-link">Video</b-list-group-item>
          </b-list-group> -->
      <!-- </b-card> -->

  <!-- </b-card-group> -->
  <div v-show="category">
  <b-dropdown id="dropdown-header" text="Categorias" class="m-2" variant="primary"  size="lg"  >
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
  </div>
    

</template>

<script>

 /* eslint-disable */

import { mapState, mapActions, mapMutations,mapGetters } from "vuex";
import {isLoggedIn,getLoggedInUser} from "../../services/authService"
import api from '../../services/api';
export default {
    name: 'PageHome',
    props:{
      category:Boolean
    },

   
    data(){
      return {
        titlePage:"MC Eletronics",
        logged:false,
      }
    },


computed:{
   ...mapGetters([
      'getProductsInCart',
      
    ]),
    // ...mapState({
    //     loggedUser: state => state.users.loggedUser
    // })
  },
  

  methods:  {
  //  ... mapActions(['addLoggedUser']),

    // ...mapMutations(["ADD_LOGGED_USER"]),

  
    hasProduct(){
      return this.getProductsInCart.length > 0
    },

    //  isLogged(){
    //    return isLoggedIn()
    //  },

    logout(){
      // localStorage.removeItem("_auth")
      // this.$router.push("/");
      // location.reload();
      this.$session.destroy();

      this.logged = false // not logged
      location.reload()
      
     },
  },
  created(){
    // const loggedUser = getLoggedInUser();
    // this.ADD_LOGGED_USER(loggedUser);
    // console.log(this.loggedUser)
    if(this.$session.exists()){
      this.logged = true // logged
    }
    
  },


  // computed: mapState(["cartProducts"]),

}

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
footer {
  background-color: #033076;
  padding: 20px;
  text-align: center;
  color: white;
  height: 2%;
}
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
.informations {
  background-color: rgb(176, 177, 179);
  margin: 0%;
  height: 240px;
}
/* Create two columns/boxes that floats next to each other */
#categories {
  float: left;
  width: 30%;
  background: white;
  padding: 1.7%;
  font-size: 100%;
}
#mid {
  color: white;
}
.logo {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
ver {
  background-color: #033076;
  border-radius: 8px;
  color: white;
}
.card-list{
       
  margin-top:auto;
  margin-left:auto;
      
}
.card{
  border: none; 
}
.item{
  width:100%;
  padding:5%;
  border-left:none;
  border-right: none;
}
.item > :hover{
  /* Background-color: #033076; */
  background-color: #033076;
  color:white;
}
nav{ 
  line-height: 1.5;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", sans-serif;
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
.nav-wrapper{
        background: linear-gradient(-90deg,#033076);
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
    .logo{
        color:white;
       
        text-decoration: none;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
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
footer {
  background-color: #033076;
  padding: 20px;
  text-align: center;
  color: white;
  height: 2%;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}

/* Create two columns/boxes that floats next to each other */


#form-search{
  width: 100%;
  margin-top: 1.7%;
}

#button-favorites{
  background-color: #033076;
  width: 10%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 8%;
  border-radius: 5%;
}
#button-bag{
  background-color: #033076;
  width: 10%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 8%;
}
#purchase-value{
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
  width: 15%;
  height: 70%;
  font-size: 70%;
  border: 0px;
  margin-left: 10%;
  border-radius: 8%;
}

.box-search{
  position: sticky;
  width: 100%;
}

.logo{
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
}
 .item{
      width:100%;
      /* padding:5%; */
      border-left:none;
      border-right: none;
    }
.item > :hover{
        background-color: #033076;
        color:white;
}

*{
  box-sizing: border-box;
}
</style>

