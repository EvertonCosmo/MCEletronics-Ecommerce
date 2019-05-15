<template>
    <b-button variant="primary"
    :disabled="!product.quantity" @click="addProductToCart(product)">
        Adicionar Carrinho 
    </b-button>

</template>

<script>

import {mapActions} from 'vuex'
/* eslint-disable */ 
export default {
    name:'AddToCart',
    props:['product'],
    
    methods: {
   		...mapActions([
        	'addToCart'
    ]),

   	addProductToCart(product) {
   		this.addToCart(product)
   	}

   },
   


}
</script>


