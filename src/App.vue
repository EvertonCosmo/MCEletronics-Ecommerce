<template>

    <div id="app">
   
          <!-- <HomePage></HomePage> -->
          <router-view></router-view>
          <!-- <Login></Login> -->

          
      
    </div>
</template>

<script>


// import HomePage from './components/PageHome'
// import Login from './components/LogonBridge'
export default {
  name: 'app',

  components:{
    // HomePage
    

  },
  mounted() {
    this.$router.replace({name:'PageHome'});
  },
   
}
</script>

<style >

</style>
