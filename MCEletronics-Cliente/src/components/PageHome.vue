<template>
  <div >
    <main-bar ></main-bar>
   
    <div
      style="background-color: #033076; height:4.1em; min-width: 90%; margin-left: 5%; margin-top: 6%;"
      class="container"
    >
      <div class="row">
        <div class="col-sm-3" style="background-color:#dedede; height:4.1rem; border:1px solid #cecece">
          
            <h5  class="navigation-options" style="margin-left:2%;margin-top:8%;color:#000;  text-shadow:1px 1px  #fff ;">
                <i class="far fa-list-alt"></i>
              CATEGORIAS
            </h5>
          
        </div>

        <div class="col-sm" >
          <router-link to="/" style=" margin-left: 15%;text-decoration:none">
            <h5 class="navigation-options ">Novidades</h5>
          </router-link>
        
        </div>
        <div class="col-sm ">
          <router-link
            to="/"
            style="color: #ffff; margin-left: 15%; text-decoration: none"
          >
            <h5 class="navigation-options ">Ofertas</h5>
          </router-link>
        </div>

        <div class="col-sm">
          <router-link
            to="/"
            style="color: #ffff; margin-left: 15%; text-decoration: none"
          >
            <h5 class="navigation-options">Sobre</h5>
          </router-link>
        </div>

      </div>


    </div>
  <div style="width:90%; margin-left:5%; height:25em; background-color: #033076">
    <div class="row" style="height:100%">
     <div class="col-sm-2"  style="height:100%">
        <ul style=" list-style:none; margin-left: 6%; padding:2%;height: 5%; width: 100%; margin-top: 1%">
          <li  >
            <a href>Celulares</a>
          </li>
          <li >
            <a  href>Notebooks</a>
          </li>
          <li >
            <a href>Computadores</a>
          </li>
          <li >
            <a href>Câmera</a>
          </li>
          <li >
            <a href>Placas</a>
          </li>
          <li >
            <a href>Som</a>
          </li>
          <li>
            <a  href>Jogos</a>
          </li>
          <li>
            <a  href>Luminarias</a>
          </li>
          <li >
            <a href="#">TV</a>
          </li>
          
        </ul>
     </div>
     <div class="col-sm-10" style="height:100%" >
      <swiper
        :options="swiperOption"
        class="swiper-box "
        style="width:90.4%; margin-left:9.6%"
       
      >
       <swiper-slide>
          <b-img :src="require(`@/assets/banner1.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide >
          <b-img :src="require(`@/assets/banner2.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner3.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner4.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner5.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <swiper-slide>
          <b-img :src="require(`@/assets/banner6.jpg`)" fluid-grow></b-img>
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </div>
    </div>
    
    </div>

    

    <products :products="productRows" :list ="true"></products>

    <PageFooter></PageFooter>
  </div>
</template>

<script>
import MainBar from "../components/shared/MainBar";
import Products from "./ProductComponents/Products";
import PageFooter from "../components/PageFooter";

import { mapGetters,mapState,mapActions } from "vuex";

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
  computed: {
    ...mapGetters(["getAllProducts"]),
    ...mapState({productRows: state => state.products.products})},

  methods: mapActions(["getProducts"]),

  created() {
    this.getProducts(); // get all products 
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
li  {
  margin-bottom: 0em;
  height: 40px;
  width: 19.7%;
  text-decoration: none;
 
}

li a  {
  margin-left: 1%;
  text-decoration: none;
  margin-top: 0.5%;
  color: #fff;
  font-size: 22px;
}
.navigation-options {
  color: #FFF;
  margin-left: 15%;
  text-shadow:1px 1px  #000 ;
  margin-top:0%;
}
.line-right {
    border-right:0.1px solid #fff
}
.logo {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
</style>