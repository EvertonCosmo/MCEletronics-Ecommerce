<template>
    <div>
      <!-- <b-navbar style="position: relative max-width:25rem" class="nav-bar" toggleable="lg" type="dark" variant="info" > -->
        <!-- <NavBar></NavBar> -->
     <header>   
      <b-navbar toggleable="lg" class="box-search">

        <b-navbar-toggle target="nav_collapse" />
        <b-navbar-brand style="font-size: 120%; position: relative; color: white" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
        <b-collapse  e is-nav style="width: 100%" id="nav_collapse">

          <div id="navigation">
            <b-nav-form>
              <b-form-group id="form-search" class="required-field">
                <b-input-group >
                  <b-form-input type="text" style="border-radius: 15px" maxlength="10" name="search"  placeholder="Buscar... "/>
                  <b-input-group-btn >
                    <i class="fas fa-search" style="position:absolute;right:8px;top: 9px;visibility:visible; color: #033076; font-size: 22px" ></i>
                  </b-input-group-btn> 
                </b-input-group>           
              </b-form-group>
            </b-nav-form> 
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



export default {
    name: 'PageHome',
   components:{
    
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

<style scoped>

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #033076;
  text-align: center;
  font-size: 35px;
  color: white;
  height: 2%;
}

article {
  float: right;
  padding: 20px;
  width: 70%;
  background-color: #fff;
  height: 100px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
  height: 100px;
}

/* Style the footer */
footer {
  background-color: #033076;
  padding: 20px;
  text-align: center;
  color: white;
  height: 2%;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}

#mid {
  color: white;
}

.mais-vendidos{
  margin: 1%;
  background-color: rgb(222, 224, 224);
  height: 400px;
}

.informacoes {
  background-color: rgb(155, 154, 154);
  margin: 0%;
  height: 250px;
}
/* Create two columns/boxes that floats next to each other */
#categorias {
  float: left;
  width: 30%;
  background: white;
  padding: 1.7%;
  font-size: 100%;
}

#form-search{
  width: 100%;
  margin-top: 1.7%;
}
/* #button-search{
  background-color: #e6f3ff;
  color: #033076;
  height: 60%;
  font-size: 45%;
  width: 20%;
  border: 10%;
  border-radius: 15%;
  height: 36px;
}    */
#button-favoritos{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: -10%;
  border-radius: 5%;
}
#button-bag{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 55%;
  border: 0px;
  margin-left: 3%;
}
#purchase-value{
  color: white;
  font-size: 55%;
  margin-left: 5%;
}
#navigation {
  width: 100%;
  margin-top: -0.5%;
}

.box-search{
  position: sticky;
  width: 100%;
}

.logo{
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
}
 .item{
      width:100%;
      /* padding:5%; */
      border-left:none;
      border-right: none;
    }
.item > :hover{
        /* Background-color: #033076; */
        background-color: #033076;
        color:white;
}
</style>

