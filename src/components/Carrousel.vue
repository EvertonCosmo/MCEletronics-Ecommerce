<template>
<div >
      <!-- <agile 
    :infinit ="true"
    :speed="700" 
    :timing="'linear'" 
    :fade="true" 
    :autoplay="true"
    :navButtons="false"
    :mobileFirst="true"
    
  >
		<div class="slide">
			<img :src="require(`@/assets/banner1.jpg`)">
		</div>
		<div class="slide">
			<img :src="require(`@/assets/banner2.jpg`)">
		</div>		
        <div class="slide">
			<img :src="require(`@/assets/banner3.jpg`)">
		</div>	
      </agile>
</div> -->

 <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000; width:100%"
    fade
    indicators
    img-width="1024"
    img-height="480"
    
  >
  <b-carousel-slide
      :img-src="require(`@/assets/banner1.jpg`)"
    ></b-carousel-slide>
      <b-carousel-slide
      :img-src="require(`@/assets/banner2.jpg`)"
    ></b-carousel-slide>
      <b-carousel-slide
      :img-src="require(`@/assets/banner3.jpg`)"
    ></b-carousel-slide>

 </b-carousel>

 
</div>
</template>


<script>
// import { VueAgile } from 'vue-agile'
export default {
    name:'carrousel',
    data(){
        return {
            banners:[
                "banner1.jpg","banner2.jpg","banner3.jpg"
            ]
        }
    },
    components:{
        
    }
    
}
</script>

<style>
.agile__dots {
  bottom: 10px;
  flex-direction: column;
  right: 50%;
  position: absolute;
}
.agile__dot {
  margin: 5px 0;
}
.agile__dot button {
  background-color: transparent;
  border: 1px solid #FFF;
  cursor: pointer;
  display: block;
  height: 10px;
  font-size: 0;
  line-height: 0;
  margin: 0;
  padding: 0;
  transition-duration: 0.3s;
  width: 10px;
}
.agile__dot--current button, .agile__dot:hover button {
  background-color: #FFF;
}

.slide {
  display: block;
  height: 500px;
  -o-object-fit: cover;
     object-fit: cover;
  width: 100%;
}
</style>


