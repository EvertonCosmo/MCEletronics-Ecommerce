
<template>


         <router-view @authenticated="setAuthenticated" /> 
 

</template>


<script>

export default {
    name:'LogonBridge',
    data(){
        return{
             authenticated: false
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