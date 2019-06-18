<template>
    <b-card
    style="max-width: 80%;border:none"
    
    
           img-top
         :img-src="require(`/home/emanoel/Documentos/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)">
    <b-card-body>
        <b-card-title>
             <router-link :to="{ name:'product-view', params: {id: this.product.id,product:product}} ">
                {{product.name}}
                <!-- {{product}} -->
             </router-link>
            
        </b-card-title>
            <b-card-text>
                R$ {{product.price}} - Estoque: {{product.quantity}}
                <AddToCart :product="product"/>
            </b-card-text>
    </b-card-body>
    </b-card>

    
  
</template>

<script>
import AddToCart from "./AddToCart"
export default {
    name:  'Product',
    props:['product'],
  
    components:{
        AddToCart
    },
    data(){
        return{
                
        }
    },
   
}
</script>

<style scoped>

</style>


