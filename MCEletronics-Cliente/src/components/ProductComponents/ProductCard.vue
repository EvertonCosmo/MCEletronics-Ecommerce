<template>
<!-- :img-src="require(`/home/emanoel/Documentos/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)" -->
<div v-if="shadow"> 


  <b-card
    style="max-width:80%;border:1px solid rgba(0,0,0,0.1); margin-top:6%;box-shadow:1px 1px 6px 2px  #888888;"
    img-top
    
  >
    <b-card-body>
      <b-card-title>

        <router-link :to="{ name:'product-view', params: {id: this.product.id,product:product}}" style="">
          {{product.name}}
        </router-link>
      </b-card-title>
      <b-card-text>
        <p>{{product.description}}</p>
      </b-card-text>
      <b-card-text>
        <strong>R$ {{product.price}}</strong><br>
        <AddToCart :product="product"/>
      </b-card-text>

    </b-card-body>
  </b-card>
  </div>

  <div v-else>
    <b-card
    style="max-width: 80%;border:none"
    img-top
    
  >
    <b-card-body>
      <b-card-title>
        <router-link :to="{ name:'product-view', params: {id: this.product.id,product:product}} ">
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
</style>


