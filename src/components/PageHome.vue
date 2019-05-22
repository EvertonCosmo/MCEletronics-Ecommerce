<template>
  <div>
    
   <main-bar :category="true"></main-bar>
  <div class="container-fluid">

  

  <swiper :options="swiperOption" class="swiper-box container" style="max-width:80%;">
        <swiper-slide>  <b-img :src="require(`@/assets/banner1.jpg`)" fluid-grow></b-img></swiper-slide>
        <swiper-slide>  <b-img :src="require(`@/assets/banner2.jpg`)" fluid-grow></b-img></swiper-slide>
        <swiper-slide>  <b-img :src="require(`@/assets/banner3.jpg`)" fluid-grow></b-img></swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
   </swiper>



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
// import Carousel from './Carousel.vue'
import Products from "./ProductComponents/Products"


import {mapGetters } from "vuex";
// import {isLoggedIn,getLoggedInUser} from "../services/authService"
export default {
  name: "PageHome",
  data(){
    return {
      swiperOption: {
          spaceBetween: 30,
          centeredSlides: true,
          autoplay: {
            delay: 2500,
            disableOnInteraction: false
          },
          pagination: {
            el: '.swiper-pagination',
            clickable: true
          },
          navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
          }, 
          breakpoints: {
            1024: {
              slidesPerView: 4,
              spaceBetween: 40
            },
            768: {
              slidesPerView: 3,
              spaceBetween: 30
            },
            640: {
              slidesPerView: 2,
              spaceBetween: 20
            },
            320: {
              slidesPerView: 1,
              spaceBetween: 10
            }
          }
        }
    
    }
  },
  computed:{
    ...mapGetters([
      'getAllProducts',
    ]),
    // ...mapState(['loggedUser']),
    
   
  },

  components:{
    MainBar,Products
  },
  
  
}

</script>

<style scoped >

.swiper-box {
    width: 100%;
    height: 100%;
    margin: 0 auto;
  }
  .swiper-item {
    height: 100%;
    text-align: center;
    font-size: 18px ;
    background: #fff;
    /* Center slide text vertically */
    display: -webkit-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    -webkit-align-items: center;
    align-items: center;
  }
</style>