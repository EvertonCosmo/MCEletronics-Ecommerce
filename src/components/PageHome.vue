<template>
  <div>
    <BarInfo></BarInfo>
    <main-bar></main-bar>

  <section style="width: 100%">
      <nav id="categorias">
        <b-list-group class="item">
          <b-list-group-item href="#some-link" >Raspberry PI</b-list-group-item>
          <b-list-group-item href="#some-link" >Computadores</b-list-group-item>
          <b-list-group-item href="#some-link" >Componentes</b-list-group-item>
          <b-list-group-item href="#some-link" >Celulares</b-list-group-item>
          <b-list-group-item href="#some-link" >Arduíno</b-list-group-item>
          <b-list-group-item href="#some-link" >Conexões</b-list-group-item>
          <b-list-group-item href="#some-link" >Shields</b-list-group-item>
          <b-list-group-item href="#some-link" >Video</b-list-group-item>
          <b-list-group-item href="#some-link" >Som</b-list-group-item>
        </b-list-group>
      </nav>
      
      <article>
        <nav>
          <div>
            <b-nav pills fill class="pages">
              <b-nav-item >Inicio</b-nav-item>
              <b-nav-item >Produtos</b-nav-item>
              <b-nav-item >Sobre </b-nav-item>
              <b-nav-item >Contato</b-nav-item>
            </b-nav>
          </div>
        </nav>

        <nav style="padding: 20px 0px 0px 0px; width: 100%">
          <div>
            <b-carousel id="carousel-fade" style="text-shadow: 0px 0px 8px #000; max-width: 70rem; max-height 1rem" fade indicators controls="true">
              <b-carousel-slide caption="Arduino uno" img-src="http://www.elecomhub.com/wp-content/uploads/2017/07/rb-ard-34-1_1-1024x480.jpg" />
              <b-carousel-slide caption="Raspeberry Pi" img-src="http://www.elecomhub.com/wp-content/uploads/2017/06/Pi2ModB1GB_-comp-1024x480.jpeg" />
              <b-carousel-slide caption="Arduino Mega" img-src="https://i1.wp.com/pcminipro.ru/wp-content/uploads/2018/01/banana-pi-r2.jpg?ssl=1" />
            </b-carousel>
          </div>  
        </nav>
      </article>
    </section>

    <nav id="mid" class="mais-vendidos"> 
      <div style="margin: 5%;">
        
         <div>
          <b-card
            title="Raspberry Pi"
             img-src="https://www.raspberrypi.org/app/uploads/2017/05/Raspberry-Pi-3-462x322.jpg"
            img-alt="Arduino Mega"
            img-top
            tag="article"
           style="max-width:30%; margin-top: 2%;color:black; margin-right:2%; height:1%"
            class="mb-2"
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            <b-button href="#" variant="primary">Comprar</b-button>
          </b-card>
        </div>
  
        <div>
          <b-card
             title="Raspberry Pi"
             img-src="https://www.raspberrypi.org/app/uploads/2017/05/Raspberry-Pi-3-462x322.jpg"
            img-alt="Arduino Mega"
            img-top
            tag="article"
           style="max-width:30%; margin-top: 2%; margin-right:2%;color:black; height:1%"
            class="mb-2"
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            <b-button href="#" variant="primary">Comprar</b-button>
          </b-card>
        </div>

        <div>
          <b-card
            title="Raspberry Pi"
            img-src="https://www.raspberrypi.org/app/uploads/2017/05/Raspberry-Pi-3-462x322.jpg"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width:30%; margin-top: 2%; margin-right:2%;color:black; height:1%"
            class="mb-2"
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            <b-button href="" @click="pagenew " variant="primary">Comprar</b-button>
          </b-card>
        </div>
      </div> 
    </nav>
    
    <nav id="mid" class="informacoes"> 
      <div style="width: 50%; ">
        <b-navbar-brand style="font-size: 200%; position: relative; color: #033076" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
      </div>
    </nav>

    <footer>
      <i class="far fa-copyright"> Direitos Reservados MC Eletronics</i>
    </footer>

  </div>
</template>

<script>

import BarInfo from './BarInfo.vue'
import MainBar from './MainBar.vue'
export default {
  name: 'PageHome',

  components:{
    BarInfo,MainBar
  },
  methods: {
    pagenew(){
      this.$router.push({name:'Product'})
    }
  },
}
</script>

<style scoped>
img{
  width:50%;
}
body {
  font-family: Arial, Helvetica, sans-serif;
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
  nav, article {
    width: 100%;
    height: auto;
  }
}

#mid {
  color: white;
}

.mais-vendidos{
  margin: 1%;
  background-color: rgb(222, 224, 224);
  height: 400px;
}

.informacoes {
  background-color: rgb(176, 177, 179);
  margin: 0%;
  height: 240px;
}
/* Create two columns/boxes that floats next to each other */
#categorias {
  float: left;
  width: 30%;
  background: white;
  padding: 1.7%;
  font-size: 100%;
}

#form-search{
  width: 100%;
  margin-top: 1.7%;
}
/* #button-search{
  background-color: #e6f3ff;
  color: #033076;
  height: 60%;
  font-size: 45%;
  width: 20%;
  border: 10%;
  border-radius: 15%;
  height: 36px;
}    */
#button-favoritos{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: -10%;
  border-radius: 5%;
}
#button-bag{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 3%;
}
#purchase-value{
  color: white;
  font-size: 55%;
  margin-left: 5%;
}
#navigation {
  width: 100%;
  margin-top: -0.5%;
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
        /* Background-color: #033076; */
        background-color: #033076;
        color:white;
}
.pages :hover{
  background-color: #033076;
  border-radius: 8px;
  color:white;
}

</style>