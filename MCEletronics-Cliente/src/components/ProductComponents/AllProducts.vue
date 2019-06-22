<template>
    <div>
        <main-bar></main-bar>
         <div class="products">
        <div class="row">
        <div class="col-md-3 order-md-1 mb-4">
          <product-filter :categories="categories" />
        </div>
        
          <div class="col-md-9 order-md-2">
            <loader-effect :time=8 v-if="loading"/>
            <products :products="products_copy" :list="false" />
        </div>

      </div>
    </div>
    </div>

</template>

<script>
/* eslint-disable */ 
import MainBar from "../shared/MainBar";
import ProductFilter from './Filter'
import LoaderEffect from './LoaderEffect'
import Products from './Products'
import api from '../../services/api'
import _ from 'lodash'
export default {
    name:'AllProducts',
    components: {MainBar,ProductFilter,LoaderEffect,Products},   
    data(){
        return{
            products:[],
            categories:[],
            loading: false,
            products_copy:[]
        }
    },
    created() {
    this.getProducts();
  },
    methods: {

      getProducts(){
        this.loading =true
        api.get().then(Response => {
          this.loading = false
          this.products = Response.data
          this.products_copy = Response.data

          this.categories = _.uniqBy(
              _.map(this.products,(object) => {
                  return _.pick(object,["category"])
              }),"category"
          )
          this.categories.unshift({category:"All"})
         
          
        }).catch(error => {
            console.log(error)
        })

      },
      filterProduct(event,productFilterID){
          const products_list = [...this.products]
          let filteredData = []
          if(event.target.value !== "All"){
            products_list.map(product => {
                if(product[productFilterID] === event.target.value){
                    filteredData.push(product);
                }
            });
            this.products_copy = filteredData 
          }else{
              filteredData = products_list
              this.products_copy = filteredData 
          }
          
        }
    },

}
</script>



