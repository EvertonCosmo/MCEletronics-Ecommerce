
<template>
  
    <div class="nav-bar">
        <router-link class="logo" to="/" >{{title}}</router-link>
        <router-view></router-view>
        <!-- <span>MC Eletronics</span> -->
    </div>
</template>

<script>

export default {
    name: 'NavBar',
    data(){
        return{
            title:"MC Eletronics"
        }
    }
    }

</script>

<style scoped>

    .nav-bar{
        background: linear-gradient(-90deg,#033076);
        box-shadow: 1px 2px 2px 2px #033076;
        /* height: 100%; */
        width: 100%;
        margin-bottom: 10px;
        margin:auto;
    }
    .logo{
        color:white;
        text-decoration: none;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 2.3rem;
        margin-left: 10px;
        
    }
    /* .logo:hover{
        color:white;
        text-decoration: none;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 3.3rem;
        margin-left: 10px;
        
    } */
</style>


