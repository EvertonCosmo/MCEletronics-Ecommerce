<template>
    <button type="button" class="btn btn primary"
    :disabled="!product.quantity" @click="addToCart(product)">
    Carrinho 
    </button>
</template>

<script>

import {mapActions} from 'vuex'

export default {
    name:'AddToCart',
    props:['product'],
    methods: mapActions([
        'addToCart'
    ])


}
</script>


