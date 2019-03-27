<template>
  <div>
    <header>   
      <b-navbar toggleable="lg" class="box-search">

        <b-navbar-toggle target="nav_collapse" />
        <b-navbar-brand style="font-size: 120%; position: relative; color: white" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
        <b-collapse is-nav style="width: 100%" id="nav_collapse">

          <div id="navigation">
            <b-nav-form>
              <b-form-group id="form-search" class="required-field">
                <b-input-group >
                  <b-form-input type="text"  maxlength="10" name="search"  placeholder="Buscar... "/>
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

    
    <b-card-group>
      <b-card style="max-width: 25rem" class="card" > 
        <b-list-group class="item ">                
          <b-list-group-item href="#"  >Painel <b-badge variant="primary" pill>14</b-badge>  <i class="fas fa-tachometer-alt float-right  card-list"></i> </b-list-group-item>
          <b-list-group-item href="#"  >Meu Perfil<i class="far fa-user float-right card-list"></i></b-list-group-item>
          <b-list-group-item href="#"  >Pedidos <i class="fas fa-shopping-basket float-right card-list"></i> </b-list-group-item>
          <b-list-group-item href="#" >Endereço <i class="fas fa-home float-right card-list"></i> </b-list-group-item>
          <b-list-group-item href="#" >Detalhes da conta<i class="fas fa-info float-right card-list"></i> </b-list-group-item>
        </b-list-group>
      </b-card>
    </b-card-group>

    <nav id="mid" class="mais-vendidos"> 
      <div style="margin: 5%;">
        <div>
          <b-card
            title="Card Title"
            img-src="https://picsum.photos/600/300/?image=25"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem; margin: 20px"
            class="mb-2"
            
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            
            <b-button href="#" variant="primary">Go somewhere</b-button> 
          </b-card>
        </div>

        <div>
          <b-card
            title="Card Title"
            img-src="https://picsum.photos/600/300/?image=25"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem; margin: 20px"
            class="mb-2"
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            <b-button href="#" variant="primary">Go somewhere</b-button>
          </b-card>
        </div>

        <div>
          <b-card
            title="Card Title"
            img-src="https://picsum.photos/600/300/?image=25"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem; margin: 20px"
            class="mb-2"
            >
            <b-card-text>
              Some quick example text to build on the card title and make up the bulk of the card's content.
            </b-card-text>
            <b-button href="#" variant="primary">Go somewhere</b-button>
          </b-card>
        </div>
      </div>
    </nav>
    
    <nav id="mid" class="informacoes"> 
      <div>
        <b-navbar-brand style="font-size: 200%; position: relative; color: #033076" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
        <!-- <i style="background-color: white" class="fas fa-headset"></i> -->
      </div>
    </nav>

    <footer>
      <i class="far fa-copyright"> Direitos Reservados MC Eletronics</i>
    </footer>

  </div>
</template>


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
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #fff;
  height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
  height: 300px;;
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
</style>