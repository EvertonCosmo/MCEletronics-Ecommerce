<template>
    <div>
      <b-navbar style="position: relative" class="nav-bar" toggleable="lg" type="dark" variant="info">
        
        <b-navbar-brand class="logo" href="PageHome">MC Eletronics</b-navbar-brand>

        <b-navbar-toggle target="nav_collapse" />
        <b-collapse is-nav id="nav_collapse">

          <b-navbar-nav class="box-search">
            <div >
              <b-nav-form>
                <b-form-input size="sm" id="form-search" class="mr-sm-2" type="text" placeholder=" Buscar..." />
                <b-button size="sm" id="button-search" class="my-2 my-sm-0" type="submit">
                   <i class="fas fa-search"></i>
                </b-button>

                <b-button id="button-favoritos"  type="submit" > 
                  <i class="far fa-heart"></i>
                </b-button>

                <b-button id="button-bag" type="submit" > 
                  <i class="fas fa-shopping-bag"></i>
                </b-button>

                <a id="purchase-value" type="text">R$ 0,00</a>
                
              </b-nav-form>

              
            </div>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav>
            
          </b-navbar-nav>

        </b-collapse>
      </b-navbar>
</div>

</template>

<script>
export default {
    name: 'PageHome',

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

