<template>
  <div id="app">
     <router-view :key="$route.fullPath"/>
  </div>
  
</template>

<script>

import HomePage from "./components/HomePage"
import MainBar from "./components/MainBar"
export default {
  name: 'app',
  components: {
   MainBar,HomePage
  }
}
</script>

<style>


</style>
