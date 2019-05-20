<template>
  <div>
    
   <main-bar></main-bar>
  <div class="container-fluid">

  

 


 
 <!-- <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000"
    fade
    indicators
    img-width="654"
    img-height="680"
  >
    
  
  
   <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          width="640"
          height="480"
          :src="require(`@/assets/banner.jpg`)"
          alt="image slot"
        >
      </b-carousel-slide>
 

      </b-carousel> -->
       <!-- <b-carousel 
       class="float-right" id="carousel-fade" style="text-shadow: 0px 0px 2px #000; max-width: 80%; margin-top:-32%; margin-right:0%" 
       
       indicators 
       
      >
                <b-carousel-slide  :img-src="require(`@/assets/banner.jpg`)" img-width="1"
       :img-height="1"/>
                <b-carousel-slide  :img-src="require(`@/assets/banner2.jpg`)" />
                <b-carousel-slide  :img-src="require(`@/assets/banner.jpg`)" />
              </b-carousel> -->

   <!-- <agile  class="" :nav-buttons="false" :autoplay-speed="5000" :speed="2500" fade="fade" pause-on-hover="pause-on-hover" pause-on-dots-hover="pause-on-dots-hover" autoplay="autoplay"><img class="slide" src="https://images.unsplash.com/photo-1509549649946-f1b6276d4f35?ixlib=rb-1.2.1&amp;q=80&amp;fm=jpg&amp;crop=entropy&amp;cs=tinysrgb&amp;w=1600&amp;fit=max&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ"/><img class="slide" src="https://images.unsplash.com/photo-1511469054436-c7dedf24c66b?ixlib=rb-1.2.1&amp;q=80&amp;fm=jpg&amp;crop=entropy&amp;cs=tinysrgb&amp;w=1600&amp;fit=max&amp;ixid=eyJhcHBfaWQiOjEyMDd9"/><img class="slide" src="https://images.unsplash.com/photo-1511135232973-c3ee80040060?ixlib=rb-1.2.1&amp;q=80&amp;fm=jpg&amp;crop=entropy&amp;cs=tinysrgb&amp;w=1600&amp;fit=max&amp;ixid=eyJhcHBfaWQiOjEyMDd9"/><img class="slide" src="https://images.unsplash.com/photo-1511231683436-44735d14c11c?ixlib=rb-1.2.1&amp;q=80&amp;fm=jpg&amp;crop=entropy&amp;cs=tinysrgb&amp;w=1600&amp;fit=max&amp;ixid=eyJhcHBfaWQiOjEyMDd9"/><img class="slide" src="https://images.unsplash.com/photo-1517677129300-07b130802f46?ixlib=rb-1.2.1&amp;q=80&amp;fm=jpg&amp;crop=entropy&amp;cs=tinysrgb&amp;w=1600&amp;fit=max&amp;ixid=eyJhcHBfaWQiOjEyMDd9"/></agile> -->
<div class="col-sm-8" style="margin-top:4%;margin-left:-3%;">
   <carousel style="max-width:100%" ></carousel>
</div> 




  <!-- <div id="mid" class="informations">
      <div style="width: 50%; ">
        <b-navbar-brand
          style="font-size: 200%; position: relative; color: #033076; margin-left: 6%"
          class="logo"
          href="PageHome"
        >MC Eletronics
        </b-navbar-brand>
      </div>

      <div class="container">
        <div class="row">
          <div style="margin-left: 20%">
            <i style="font-size: 80px; color: #2D2C3F; float: right" class="fab fa-tencent-weibo"></i>
          </div>
          <div style="color: #2D2C3F" class="col-sm-4">
            <h3>Fale conosco</h3>
            <p>(88) 0 0000-0000</p>
          </div>
          <div style="margin-left: 10%; margin-top: -2%; color: #2D2C3F; float: right" >
            <h3>FAQ</h3>
            <p>Como comprar</p>
            <p>Trocas</p>
            <p>Envios</p>
            <p>Devoluções</p>
          </div>
        </div>
      </div>
  </div>

    <footer>
      <i class="far fa-copyright">Direitos Reservados MC Eletronics</i>
    </footer> -->
  <products></products>
  </div>
</div>
</template>

<script>

import MainBar from '../components/shared/MainBar'
import Carousel from './Carrousel.vue'
import Products from "./ProductComponents/Products"


import {mapGetters } from "vuex";
// import {isLoggedIn,getLoggedInUser} from "../services/authService"
export default {
  name: "PageHome",
  computed:{
    ...mapGetters([
      'getAllProducts',
    ]),
    // ...mapState(['loggedUser']),
    
   
  },

  components:{
    MainBar,Products,Carousel
  },
  
  
}

</script>

<style scoped  >


</style>