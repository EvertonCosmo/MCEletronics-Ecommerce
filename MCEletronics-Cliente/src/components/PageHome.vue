<template>
  <div>
    <main-bar :category="true"></main-bar>
    <div class="container-fluid">
      <swiper :options="swiperOption" class="swiper-box container" style="max-width:80%;">
        <swiper-slide>
          <b-img :src="require(`@/assets/banner1.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner2.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner3.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </div>

    <products></products>

    <PageFooter></PageFooter>
  </div>
</template>

<script>
import MainBar from "../components/shared/MainBar";
// import Carousel from './Carousel.vue'
import Products from "./ProductComponents/Products";
import PageFooter from "../components/PageFooter";

import { mapGetters } from "vuex";
// import {isLoggedIn,getLoggedInUser} from "../services/authService"
export default {
  name: "PageHome",
  data() {
    return {
      swiperOption: {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
          delay: 2500,
          disableOnInteraction: false
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
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
    };
  },
  computed:{
    ...mapGetters([
      'getAllProducts',
    ]),
  
    
   
  },
  components: {
    MainBar,
    Products,
    PageFooter
  }
};
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
  font-size: 18px;
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
/* footer {
  background-color: #033076;
  padding: 20px;
  text-align: center;
  color: white;
  height: 2%;
} */
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
/* .informations {
  background-color: rgb(176, 177, 179);
  margin: 0%;
  height: 240px;
} */
/* Create two columns/boxes that floats next to each other */
#categories {
  float: left;
  width: 30%;
  background: white;
  padding: 1.7%;
  font-size: 100%;
}
/* #mid {
  color: white;
} */
.logo {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
</style>