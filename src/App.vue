<template>
    <div id="app">
      <!-- <div id="nav"> -->
        <!-- <Login></Login> -->
         
        <!-- if true go to home page(Login) -->

          <router-link v-if="authenticated" to="/Login" class="float-right" v-on:click.native = "logout()" replace>
                Logout
          </router-link>
          <!-- directive v-on listening event of authenticated -->
           <router-view @authenticated="setAuthenticated" /> 
          
          
      <!-- </div> -->
       <!-- <router-link to="/login">
           Login
           </router-link> -->
    </div>
</template>

<script>

// import Login from './components/Login.vue'

export default {
  name: 'app',
  // components:{
  //   Login
  // },
  data(){
    return {
       authenticated: false, 
       mockAccount:{ // fake account to simulate login 
          email:"everton@gmail.com",
          password:'cosmo123'
       }
    }
  },
  mounted(){ // initialize component 
    if(!this.authenticated){ // listen the emit event of Login.vue
      this.$router.replace({name:'Login'}); // // replace router(page) to Login likes initial page
      
    }
  },
  methods:{
    setAuthenticated(status){
      this.authenticated = status;
    },
    logout(){
      this.authenticated = false;
    }
  }


}
</script>

<style >
.float-right{
  color:white;
  text-decoration: none;
  font-size: 2em;
  margin-right: 20px;
  
}
</style>
