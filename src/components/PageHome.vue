<template>
  <div>
    <!-- <BarInfo></BarInfo> -->
    <main-bar></main-bar>




  <b-card-group>
      <b-card style="max-width:25rem" class="card"> 
          <b-list-group class="item ">
              <b-list-group-item href="#some-link"> Raspberry PI</b-list-group-item>
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
   <div>
      <agile :autoplay-speed="5000" :speed="1500" fade pause-on-hover pause-on-dots-hover autoplay>
        <div class="slide">
          <img src="../assets/Raspberry-Pi-3-462x322.jpg"/>
        </div>	
      </agile>
   </div>



  <div id="mid" class="informations">
      <div style="width: 50%; ">
        <b-navbar-brand
          style="font-size: 200%; position: relative; color: #033076"
          class="logo"
          href="PageHome"
        >MC Eletronics
        </b-navbar-brand>
      </div>

      <div class="container">
        <div class="row">
          <div style="margin-left: 5%">
            <!-- <i style="font-size: 50%; background-color: #111" class="fas fa-headset"></i> -->
            <i style="font-size: 80px; color: #111; float: right" class="fab fa-tencent-weibo"></i>
          </div>
          <div style="color: #111" class="col-sm-4">
            <h3>Fale conosco</h3>
            <p>(88) 0 0000-0000</p>
          </div>
          <div style="margin-left: 30%; margin-top: -2%; color: #111; float: right" >
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
    </footer>
  </div>
</template>

<script>

import MainBar from '../components/BarComponents/MainBar.vue'
import { VueAgile } from 'vue-agile'

export default {
  name: "PageHome",

  components:{
    MainBar,agile: VueAgile
  },
  methods: {
    pagenew() {
      this.$router.push({ name: "Product" });
    }
  }
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