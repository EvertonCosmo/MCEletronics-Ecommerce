<template>

    <div id="app">
   
       <router-view :key="$route.fullPath"/>

    </div>
</template>

<script>


/* eslint-disable */ 
export default {
  name: 'app',

}
</script>

<style >

</style>
