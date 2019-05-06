
<template>
  <div>
        <!-- <BarInfo></BarInfo> -->
    <main-bar></main-bar>

    <div style="width: 50%; height: 50px;">
            <b-navbar-brand class="my-basket">Minha Cesta <i class="fas fa-shopping-basket" style="margin-left: 5%"></i> </b-navbar-brand>
    </div>

    <section style="width: 100%; margin-top: 1%" >
          
        <div class="selection-box" style="max-width: 55rem; width: 100%; display: block" >

            <div class="container">

                <div class="card shopping-cart">

                    <div class="card-body">
                        <!-- PRODUCT -->
                        <ul :key="product.id" v-for="product in products">
                            <div class="row" >
                            
                                <div class="col-12 col-sm-12 col-md-2 text-center">
                                    <img class="img-responsive" src="http://placehold.it/120x80" alt="prewiew" width="120" height="80">
                                </div>

                                <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                                    
                                    <h4 class="product-name"><strong>{{product.name}}</strong></h4>
                                    <h4>
                                        <small>{{product.type}}</small>
                                    </h4>  

                                </div>

                                <div style="margin-top: 3%" class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                                
                                    <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 10px">
                                        <h6>valor: {{product.value}} <span class="text-muted"> x </span></h6>
                                    </div>

                                    <div class="col-4 col-sm-4 col-md-4">
                                        <div class="quantity">

                                            <input type="button" value="+" class="plus">
                                            <input type="number" step="1" max="99" min="1" value="1" title="Qty" class="qty"
                                                size="4">
                                            <input type="button" value="-" class="minus">

                                        </div>
                                    </div>

                                    <div class="col-2 col-sm-2 col-md-2 text-right">
                                        <button type="button" class="btn btn-outline-danger btn-xs">
                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                        </button>
                                    </div>   

                                </div>

                            </div>

                            <hr>
                        </ul>   

                    </div>

                    <div class="card-footer">
                        <div >                                                 
                            <label for="text-password">Calcular Frete </label>
                            <b-input type="text"  placeholder="00000-000"></b-input>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
      <!-- <div class="purchase-information" style="max-width: 25rem; width: 100%; display: block" >       
        <div style="background-color: rgb(176, 177, 179); height:270px">
            
        </div>

        <b-button style= "background-color:#033076; height: 15%; margin-top: 2%;" type="submit"  block variant="primary">
          <i class="fas fa-cart-plus" style="font-size:100%"> Continuar Compra</i> 
        </b-button>
      </div> -->
        <div class="purchase-information">
            <b-card-group>
                <b-card style="max-width:25rem; background-color: rgb(213, 213, 213)" class="card-left"> 
                    <!-- <b-list-group class="item-left "> -->
                        
                    <h5>Resumo da compra R$</h5>
                    <h5>Subtotal (Qtd. Produtos)</h5>
                    <h5>Frete</h5>
                    <hr>
                    <h4>TOTAL</h4>
                    <h5>R$ 450,90 em 1x no Boleto Bancário</h5>
                    <h5>R$ 450,90 em 1x no Boleto Bancário</h5>

                    <!-- </b-list-group> -->
                </b-card>

            </b-card-group>

            <b-button style= "background-color:#033076; height: 15%; margin-top: 1%;" type="submit"  block variant="primary">
                <i class="fas fa-cart-plus" style="font-size:100%"> Continuar Compra</i> 
            </b-button>

        </div>

    </section>

  </div>

</template>

<script>
/*eslint no-console: "error"*/
/* eslint-disable */
import MainBar from "../components/BarComponents/MainBar.vue";
import axios from "axios"

export default {
  name: "PageHome",

  data(){
    return{
      api:'http://localhost:3000/products',
      products:[]
    }
  },

  components: {
    MainBar
  },

  created(){
    axios.get(this.api)
    .then(Response => {
       this.products = Response.data;
        // console.log(Response.data)
    })
  },
}
</script>

<style >

.my-basket {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 250%; 
  margin-top:3%;
  color: #033076;
  margin-left:4%;
}

.selection-box {
  width: 70%;
  margin-top: 2%;
  margin-left: 1%;
  margin-right: 1%;
  float: left;
}  

.purchase-information {
    float: right;
    /* margin-left: 1%;
    
    height: 300px;
    width: 30%; */
   margin-top: 3.5%; 
   margin-right: 5%;
}

.quantity {
    float: left;
    margin-right: 15px;
    background-color: #111;
    position: relative;
    width: 70px;
    overflow: hidden
}

.quantity input {
    margin: 0;
    text-align: center;
    width: 15px;
    height: 15px;
    padding: 0;
    float: right;
    color: #111;
    font-size: 20px;
    border: 0;
    outline: 0;
    background-color: #D5D5D5;
}

.quantity input.qty {
    position: relative;
    border: 0;
    width: 100%;
    height: 40px;
    padding: 10px 25px 10px 10px;
    text-align: center;
    font-weight: 400;
    font-size: 15px;
    border-radius: 0;
    background-clip: padding-box
}

.quantity .minus, .quantity .plus {
    line-height: 0;
    background-clip: padding-box;
    -webkit-border-radius: 0;
    -moz-border-radius: 0;
    border-radius: 0;
    -webkit-background-size: 6px 30px;
    -moz-background-size: 6px 30px;
    color: #bbb;
    font-size: 20px;
    position: absolute;
    height: 50%;
    border: 0;
    right: 0;
    padding: 0;
    width: 25px;
    z-index: 3
}

.quantity .minus:hover, .quantity .plus:hover {
    background-color: #dad8da
}

.quantity .minus {
    bottom: 0
}
.shopping-cart {
    margin-top: 20px;
}
.card-left{
  border: none; 
}
.item-left{
  width:100%;
  padding:5%;
  border-left:none;
  border-right: none;
}

</style>