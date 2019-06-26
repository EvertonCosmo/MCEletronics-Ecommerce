<template>

<div v-if="shadow"> 


  <b-card
    style="max-width:100%;border:1px solid rgba(0,0,0,0.1); margin-top:1%;box-shadow:1px 1px 6px 2px  #888888;"
    :img-src="require(`/home/everton/MCELETRONICS/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)" 
    img-top    
  >
    <b-card-body>
      <b-card-title>

        <router-link :to="{ name:'product-view', params: {name: this.product.name,product:product}}" style="">
          {{product.name}}
        </router-link>
      </b-card-title>
      <b-card-text>
        <p>{{product.name}}</p>
      </b-card-text>
        <b-card-text>
          <strong>R$ {{product.price}}</strong>
        </b-card-text>
      <b-card-text>
        
            <AddToCart :product="product"/>
       
        
      </b-card-text>

    </b-card-body>
    
  </b-card>
  </div>

  <div v-else>
    <b-card
    style="max-width: 50%;border:none;"
    :img-src="require(`/home/everton/MCELETRONICS/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)" 
    img-top
    
  >
    <b-card-body>
      <b-card-title>
        <router-link :to="{ name:'product-view', params: {name: this.product.name,product:product}} ">
          {{product.name}}
        </router-link>
      </b-card-title>
      <b-card-text>
        <strong> R$ {{product.price}}</strong>
        <br>
        <AddToCart :product="product"/>
      </b-card-text>
    </b-card-body>
  </b-card>
  </div>

</template>

<script>
import AddToCart from "./AddToCart";
export default {
  name: "Product",
  props: ["product","shadow"],

  components: {
    AddToCart
  },
  data() {
    return {};
  }
};
</script>

<style scoped>
img{
  width: 50%;
  height: 100%;
  margin-left: 20%
 
}
</style>


