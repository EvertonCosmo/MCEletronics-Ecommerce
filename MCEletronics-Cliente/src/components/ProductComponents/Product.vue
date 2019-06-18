<template>
    <b-card
    img-top
    :img-src="require(`/home/emanoel/Documentos/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)"
    style="max-width: 80%;border:none"

    
    >
    <b-card-body>
        <b-card-title>
             <router-link :to="{ name:'product-view', params: {id: product.id,product:product}} ">
                {{product.name}}
             </router-link>
            
        </b-card-title>
            <b-card-text>
                R$ {{product.price}} - Estoque: {{product.quantity}}
                <AddToCart :product="product"/>
            </b-card-text>
    </b-card-body>
    </b-card>

    
    <!-- <div class="cart text-center" >
        <div class="card-img-top vue-logo"></div>

        <div class="card-body">
            <h5 class="card-title">{{product.name}}</h5>
            <p class="card-text"> R$ {{product.price}} - Estoque: {{product.quantity}}</p>
            <AddToCart :product="product"/>
            
        </div>
    </div> -->
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
/* solid 1px rgba(0,0,0,.2);margin-left:10% */
    .logo{
        padding-bottom: 75%;
        background-size: 40%;
    }
</style>


