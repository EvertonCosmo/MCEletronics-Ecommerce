<template>
    <div>
        <h3>Recomendados</h3>
        <b-row v-for="(row,index) in productRows" :key="index" style="width:70%; margin-left:%">
            <div class="col-sm-4 mb-6" v-for="product in row" :key="product.id">
                <Product :product="product" track-id="id"/>
            </div>
        </b-row>

       
    </div>
</template>

<script>
import Product from "./Product"
import { mapActions, mapState } from 'vuex'
// import chunk from 'chunk'
 // Chunk converts arrays like [1,2,3,4,5] into arrays of arrays like [[1,2], [3,4], [5]].

export default {
    name:"Products",
    // props:['products'],
    data(){
        return {
          
        }
    },
    components: { 
         Product
     
    },
   computed: mapState({
    productRows: state => state.products.products
    
  }),
     methods: mapActions([
         'getProducts'
     ]),


  created () {
    this.getProducts()
    
    
  }
    
}
</script>


