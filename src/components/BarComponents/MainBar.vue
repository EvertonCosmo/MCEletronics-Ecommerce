<template>
    <div>
      <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
        <!-- <NavBar></NavBar> -->
     <header>   
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
                  <b-form-input type="search" style="border-radius: 6px; z-index: 0" maxlength="10" name="search"  placeholder="Buscar... "/>

                  <!-- <b-input-group style="cursor:pointer" > -->
                           
                           <i class="fas fa-search" style=" z-index: 1; position:absolute;right:2%;top: 25%;visibility:visible; color: #033076; font-size:50%" ></i>
                  
                   
                  <!-- </b-input-group>  -->

                </b-input-group>    
                       
              </b-form-group>
            </b-nav-form> 
          </div>



          <div style="max-width: 25rem; width: 100%; display: block">
            
            <b-button  id="button-favorites" type="submit" > 
              <i class="far fa-heart"></i>
            </b-button>
            <router-link :to="{name:'bag'}">
                <b-button id="button-bag">
                   <i class="fas fa-shopping-cart">
                        <!-- <span>{{value}}</span> -->
                   </i>
                 
                  
                </b-button>
                  <!-- <span id="purchase-value">R$</span> -->
            </router-link>
                 <!-- <b-badge variant="primary">{{quantity}}</b-badge></i>  -->
            
              

           
            <router-link :to="{name:'login'}">
              <b-button id="button-usuer">
                <i class="fas fa-user-circle"></i>
            
              </b-button>
            </router-link>
           
          </div>
        <!-- BODY BANNER -->
        


        </b-collapse>
        
      </b-navbar>
    </header>
    
    </div>
</template>

<script>



export default {
    name: 'PageHome',

   components:{
    
   },
    data(){
      return {
        titlePage:"MC Eletronics",
        quantity:10,
        value:"100,00"
      }
    },

  methods:{
  
  },  
}

</script>

<style scoped>
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
#button-usuer {
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

