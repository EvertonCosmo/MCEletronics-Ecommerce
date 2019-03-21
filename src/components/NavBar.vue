
<template>
    <div class="nav-bar">
        <span>MC Eletronics</span>
    </div>
</template>

<script>

export default {
    name: 'NavBar',
     props:{ msg:String}
    }

</script>

<style>

    .nav-bar{
        background: linear-gradient(-90deg,#033076);
        box-shadow: 1px 2px 2px 2px #033076;
        height: 80px;
        width: 100%;
        margin-bottom: 0px;
    }
    span{
        color:white;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 2.3rem;
        margin-left: 10px;
        
    }
</style>


