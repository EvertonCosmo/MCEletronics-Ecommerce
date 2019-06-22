<template>
    <div class="productFilter">

    <div id="prdfilter">
      <h4 class="d-flex mb-3">
        <span class="text-muted">Filtros:</span>
      </h4>
       

      <div class="form-group">
           <select
          class="form-control"
          id="filterPrdCty"
          v-model="selectedCategory"
          @change="(event) => updateCategory(event, 'category')"
          >
          <option
            v-for="(cat, index) in categories"
            :key="index"
            v-bind:value="cat.category"
          >{{cat.category}}</option>
        </select>
      </div>
    </div>

    </div>
   
    

  
</template>

<script>

export default {
    name:'Filter',
    props:['categories'],
    data(){

        return { 
           
            selectedCategory: 'All'
           
        }
    },
    methods:{
      updateCategory(event, productFilterID){
           this.$parent.filterProduct(event, productFilterID);
      }
    }
    
}
</script>

<style scoped>
.productFilter #prdfilter{
    text-align: start !important;
  }
</style>

