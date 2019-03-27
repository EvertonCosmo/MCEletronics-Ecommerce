
<template>
  <div>
    <header>   
      <b-navbar toggleable="lg" class="box-search">

        <b-navbar-toggle target="nav_collapse" />
        <b-navbar-brand style="font-size: 120%; position: relative;" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
        <b-collapse is-nav style="width: 100%" id="nav_collapse">

          <div id="navegacao">
            <b-nav-form>
              
              <b-form-input  id="form-search" class="mr-sm-2" type="text" placeholder=" Buscar..." />
              <div style="width: 25%">
                <b-button id="button-search" type="submit">
                  <i class="fas fa-search"></i>
                </b-button>

                <b-button id="button-favoritos" type="submit" > 
                  <i class="far fa-heart"></i>
                </b-button>

                <b-button id="button-bag" type="submit" > 
                  <i class="fas fa-shopping-bag"></i>
                </b-button>

                <a id="purchase-value" type="text">R$ 0,00</a>
              </div>
            </b-nav-form>  
          </div>
        </b-collapse>
      </b-navbar>
    </header>

    <section style="width: 100%">
      <nav id="categorias">
        <b-list-group>
          <b-list-group-item href="#some-link" style="background: #033076; color: white">Categorias</b-list-group-item>
          <b-list-group-item href="#some-link" >Componentes</b-list-group-item>
          <b-list-group-item href="#some-link" >Computador</b-list-group-item>
          <b-list-group-item href="#some-link" >Celular</b-list-group-item>
          <b-list-group-item href="#some-link" >Som</b-list-group-item>
          <b-list-group-item href="#some-link" >Video</b-list-group-item>
          <b-list-group-item href="#some-link" >Variedades</b-list-group-item>
        </b-list-group>
      </nav>
      
      <article>
        <nav>
          <div>
            <b-nav pills fill tabs>
              <b-nav-item active >Inicio</b-nav-item>
              <b-nav-item >Produtos</b-nav-item>
              <b-nav-item >Sobre</b-nav-item>
              <b-nav-item >Contato</b-nav-item>
            </b-nav>
          </div>
        </nav>

        <nav style="padding: 20px 0px 0px 0px; width: 100%">
          <div>
            <b-carousel id="carousel-fade" style="text-shadow: 0px 0px 8px #000; max-width: 70rem" fade indicators controls="true">
              <b-carousel-slide caption="First slide" img-src="https://picsum.photos/1024/480/?image=10" />
              <b-carousel-slide caption="Second Slide" img-src="https://picsum.photos/1024/480/?image=12" />
              <b-carousel-slide caption="Third Slide" img-src="https://picsum.photos/1024/480/?image=22" />
            </b-carousel>
          </div>  
        </nav>
      </article>
    </section>

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
* {
  /* box-sizing: border-box; */
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #033076;
  /* padding: 30px; */
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
  width: 70%;
  border-radius: 10px;
  background: #e6f3ff;
  font-size: 40%;
  margin-top: 0.5%;
}
#button-search{
  background-color: #e6f3ff;
  color: #033076;
  height: 60%;
  font-size: 45%;
  width: 20%;
  border: 10%;
  border-radius: 15%;
  height: 36px;
  /* margin-top: 8%; */
}   
#button-favoritos{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 60%;
  border: 0px;
  margin-left: 5%;
  border-radius: 5%;
}
#button-bag{
  background-color: #033076;
  width: 20%;
  height: 70%;
  font-size: 60%;
  border: 0px;
  margin-left: 1%;
}
#purchase-value{
  color: white;
  font-size: 50%;
  margin-left: 3%;
  /* margin-top: 5%; */
}
#navegacao {
  width: 100%;
  margin-top: -0.5%;
}

.box-search{
  position: sticky;
  width: 100%;
}

.logo{
  color:white;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
}
</style>