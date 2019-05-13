<template>
  <div>
    <!-- <BarInfo></BarInfo> -->
   <main-bar></main-bar>
  
<div class="container" >
 <b-row>

 <div class="col-md-5" >
  <b-card-group >
      <b-card style="max-width:25rem" class="card" > 
          <b-list-group class="item">
            <b-list-group-item active><i class="fas fa-list-ul"></i> Categorias</b-list-group-item>
              <b-list-group-item href="#some-link">Raspberry PI</b-list-group-item>
              <b-list-group-item href="#some-link">Computadores</b-list-group-item>
              <b-list-group-item href="#some-link">Componentes</b-list-group-item>
              <b-list-group-item href="#some-link">Celulares</b-list-group-item>
              <b-list-group-item href="#some-link">Arduíno</b-list-group-item>
              <b-list-group-item href="#some-link">Conexões</b-list-group-item>
              <b-list-group-item href="#some-link">Shields</b-list-group-item>
              <b-list-group-item href="#some-link">Video</b-list-group-item>
          </b-list-group>
      </b-card>

  </b-card-group>
  </div>


 
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
   <!-- <aside class="float-right" role="complementary">
   <carousel></carousel>
   </aside> -->
 </b-row>
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
</template>

<script>

import MainBar from '../components/BarComponents/MainBar.vue'
// import Carousel from './Carrousel.vue'
import Products from "./ProductComponents/Products"

export default {
  name: "PageHome",

  data(){
    return {
      
    }
  },
  components:{
    MainBar,Products
  },

  methods: {
    
  },
}

</script>

<style scoped  >


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
</style>