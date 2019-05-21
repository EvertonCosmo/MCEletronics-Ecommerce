<template>
    <div>
        <!-- <h3>Recomendados</h3> -->
         <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Recomendados</li>
                    <li class="ml-auto" aria-current="page"><router-link to="/">MostrarTodos</router-link></li>
                </ol>
      
    </nav>
        <hr>
        <b-row v-for="(row,index) in productRows" :key="index">
            <div class="col-sm-3 mb-4 " v-for="product in row" :key="product.id">
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


