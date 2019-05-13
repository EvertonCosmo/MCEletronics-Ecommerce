<template>
    <div>
        <h3>Recomendados</h3>
        <div class="row" v-for="(row,index) in productsRows" :key="index">
            <div class="col-sm-4 mb-4" v-for="product in row" :key="product.id">
                <Product :product="product" track-id="id"/>

            </div>
        </div>
    </div>
</template>

<script>
import Product from "./Product"
import {mapActions,mapState} from "vuex"
import chunk from 'chunk' // Chunk converts arrays like [1,2,3,4,5] into arrays of arrays like [[1,2], [3,4], [5]].

export default {
    name:"Products",
    components: { 
         Product
     
    }, 
    computed: mapState({
        ProductRows: state => chunk(state.products.all,3)
    }),
     methods: mapActions([
         'getProducts'
     ]),


  created () {
    this.getProducts()
  }
    
}
</script>


