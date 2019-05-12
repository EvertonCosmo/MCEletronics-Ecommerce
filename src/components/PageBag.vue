
<template>
  <div>
        <!-- <BarInfo></BarInfo> -->
    <main-bar></main-bar>

    <section style="width: 100%;padding: 0px 0px 2% 0px" >
          
      <div style="width: 50%; height: 50px;">
        <b-navbar-brand class="my-basket">Minha Cesta <i class="fas fa-shopping-basket" style="margin-left: 5%"></i> </b-navbar-brand>
      </div>

      <div class="row" style="margin-top: 1%">

        <div class="selection-box">
          <button >GET ALL</button>
            <ul>
             <li :key="product.id" v-for="product in products">
               {{product.name}}
             </li>
            </ul>
        </div>

        <div class="purchase-information">       
          <div style="background-color: rgb(176, 177, 179); height:270px">
          </div>

          <b-button v-if="!loading" style= "background-color:#033076; height: 15%; margin-top: 2%;" type="submit"  block variant="primary">
            <i class="fas fa-cart-plus" style="font-size:150%"> Continuar Compra</i> 
          </b-button>

        </div>
          
      </div>

    </section>
  </div>
</template>

<script>
/*eslint no-console: "error"*/
/* eslint-disable */
import MainBar from "../components/BarComponents/MainBar.vue";
import axios from "axios"

export default {
  name: "PageHome",

  data(){
    return{
      api:'http://localhost:8080/project/api/products',
      products:[]
    }
  },

  components: {
    MainBar
  },

  created(){
    axios.get(this.api)
    .then(Response => {
       this.products = Response.data;
        console.log(Response.data)
       
     })
    
  },


  }



</script>

<style>

.my-basket {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 300%; 
  margin-top:3%;
  color: #033076;
  margin-left:8%;
}

.selection-box {
  background-color: rgb(176, 177, 179);
  width: 60%;
  margin-top: 4%;
  margin-left:5%;
  height: 540px;
  float: left;
}  

.purchase-information {
  float: right;
  width: 30%;
  margin-top: 4%;
  margin-left:1%;
  height: 300px;
}
</style>