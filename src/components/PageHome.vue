
<template>
  <div>
    <header>
      
      <b-navbar-nav class="box-search">
            <div >
              <b-nav-form>
                <b-navbar-brand style="font-size: 40px" class="logo" href="PageHome">MC Eletronics</b-navbar-brand>
                <b-form-input size="sm" id="form-search" class="mr-sm-2" type="text" placeholder=" Buscar..." />
               <div>
                <b-button id="button-search" type="submit">
                   <i class="fas fa-search"></i>
                </b-button>

                <b-button id="button-favoritos"  type="submit" > 
                  <i class="far fa-heart"></i>
                </b-button>

                <b-button id="button-bag" type="submit" > 
                  <i class="fas fa-shopping-bag"></i>
                </b-button>

                <a id="purchase-value" type="text">R$ 0,00</a>

               </div>
                
                
              </b-nav-form>

              
            </div>
          </b-navbar-nav>
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
  

  <!-- <nav id="mais">
    <div>
    <h4>Top and Bottom</h4>
    <b-card-group deck>
      <b-card img-src="https://placekitten.com/1000/300" img-alt="Card image" img-top>
        <b-card-text>
          Some quick example text to build on the card and make up the bulk of the card's content.
        </b-card-text>
      </b-card>      
    </b-card-group>
  </div>
  </nav> -->
</section>
  <nav id="mais"> <div>
    <b-card
      title="Card Title"
      img-src="https://picsum.photos/600/300/?image=25"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 20rem;"
      class="mb-2"
    >
      <b-card-text>
        Some quick example text to build on the card title and make up the bulk of the card's content.
      </b-card-text>

      <b-button href="#" variant="primary">Go somewhere</b-button>
    </b-card>
</div>


  </nav>
  <footer>
    <p>Footer</p>
  </footer>
  </div>

</template>


<style scoped>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #033076;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}
#mais {
  background-color: #ccc;
  margin: 20px ;
  height: 400px;
  /* text-align: center; */
  color: white;
}
/* Create two columns/boxes that floats next to each other */
#categorias {
  float: left;
  width: 30%;
  /* height: 400px; only for demonstration, should be removed */
  background: white;
  padding: 20px;
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
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
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
</style>