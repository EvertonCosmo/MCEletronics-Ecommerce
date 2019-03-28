<template>
    <div>
      <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
        <!-- <NavBar></NavBar> -->
     <header>
      <b-navbar toggleable="lg" class="box-search">

        <b-navbar-toggle target="nav_collapse" />
        <b-navbar-brand style="font-size: 120%; position: relative; color: white" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
        <b-collapse is-nav style="width: 100% border:none" id="nav_collapse">

          <div id="navigation">
         
             
                <b-input-group >
                  <b-form-input type="text"  maxlength="10" name="search"  placeholder="Buscar... "/>
                    <b-input-group-btn >
                    <i class="fas fa-search" style="position:absolute;right:8px;top: 9px;visibility:visible; color: #033076; font-size: 22px" ></i>
                    </b-input-group-btn> 
                </b-input-group>           
             
          </div>

          <div style="max-width: 25rem; width: 100%; display: block">
            <b-button  id="button-favoritos" type="submit" > 
              <i class="far fa-heart"></i>
            </b-button>

            <b-button  id="button-bag" type="submit" > 
              <i class="fas fa-shopping-bag"></i>
            </b-button>

            <a id="purchase-value" type="text">R$ 0,00</a>
          </div>

        </b-collapse>
      </b-navbar>
    </header>
    </div>
</template>

<script>


import NavBar from './NavBar'
export default {
    name: 'PageHome',
   components:{
     NavBar
   },
    data(){
      return {
        input:{
            search:"",
            valor: ""           
        }
      }
    }
}

</script>

<style>
/* Style the header */
 header {
  background: linear-gradient(-90deg,#033076);
  text-align: center;
  font-size: 35px;
  color: white;
  box-shadow: 1px 2px 2px 2px #033076;
  height: 80px;

} 

.nav-bar{
        background: linear-gradient(-90deg,#033076);
        position: fixed;
        box-shadow: 1px 2px 2px 2px #033076;
        height: 80px;
        width: 100%;
        margin-bottom: 0px;    
        padding: 30px;
        text-align: center;
  
    }

.logo{
        color:white;
        position: relative;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
}

#form-search{
    position: relative;
    width:700px;;
    height: 40px;
    border-radius: 10px;
    background: #e6f3ff;
    font-size: 18px;
}
#button-search{
    background-color: #e6f3ff;
    color: #033076;
    height: 40px;
    font-size: 20px;
    width: 50px;
    border: 5px;
    border-radius: 5px;
}   
#button-favoritos{
    background-color: #033076;
    width: 50px;
    height: 40px;
    /* position: relative; */
    font-size: 25px;
    border: 0px;
    margin-left: 30px;
    border-radius: 5px;
}
#button-bag{
    background-color: #033076;
    width: 50px;
    height: 40px;
    /* position: relative; */
    font-size: 25px;
    border: 0px;
    margin-left: 25px;
}
#purchase-value{
  color: white;
  font-size: 20px;
  margin-left: 25px;
  margin-top: 10px;
}
.box-search{
    position: fixed;
    margin-left: 50px;
    width: 100%;
}


</style>

