
<template>
<div>
    <NavBar></NavBar>
    <div id='login'>
        <h1>DashBoard</h1>

        <p>
           Email Logado: {{email}}
        </p>
    </div>
</div>
</template>

<script>
import NavBar from './NavBar.vue'

export default {
    name:'PageLogin',
    
    components:{
        NavBar
    },
    
    data() {
        return{
            email : this.$parent.mockAccount.email,
        };  
    }
}
</script>

<style scoped>
    #login{
        background-color: #FFFFFF;
        border: 1px solid #CCCCCC;
        padding: 20px;
        margin-top: 10px;
    }
</style>


