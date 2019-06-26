<template>
  <div>
    <main-bar></main-bar>
    <div v-if="hasProduct()">
      <div style="width: 50%; height: 50px;">
        <b-navbar-brand style="font-size: 250%" class="my-basket">
          Minha Cesta<i class="fas fa-shopping-basket" style="margin-left: 5%"></i>
        </b-navbar-brand>
      </div>

      <section style="width: 100%; margin-top: 1%; margin-bottom: 8px">
        <div
          class="selection-box"
          style="max-width: 55rem; width: 100%; display: block; margin-bottom: 5%"
        >
         
          <div class="container">
            <div class="card shopping-cart">
              <div class="card-body">
                <ul :key="product.id" v-for="product of products">
                  <div class="row">
                    <div class="col-12 col-sm-12 col-md-2 text-center">
                      <b-img
                        :src="require(`/home/everton/MCELETRONICS/MCEletronics/MCEletronics-ADM/src/assets/${product.id}.jpg`)"
                        fluid-grow
                      ></b-img>
                    </div>

                    <div style="max-width: 35%" class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                      <h4 >
                          <router-link :to="{ name:'product-view', params: {name: product.name,product:product}}" style="text-decoration:none; color:black">
                                <strong>{{product.name}}</strong>
                          </router-link>
                      </h4>
                      <h4>
                        <small>{{product.category}}</small>
                      </h4>
                    </div>

                    <div style="margin-top: 1%; width: 39%">
                      
                      <div class="container">
                        <div class="row">
                          <div class="col-sm">
                            
                            <div style="width: 100%">
                              <!-- <input type="text" class="inputQuantity"/>
                              <div>
                                <button class="plus">+</button>
                                <button class="minus">-</button>
                              </div> -->
                              <!-- Example split danger button -->
<!-- Example split danger button -->
                              <div class="dropdown">
                                <button class="dropbtn"><span style="margin-top: -3px; position: relative">{{product.quantity}}</span></button>
                                <div class="dropdown-content">
                                <a style="text-decoration: none" href="#">1</a>
                                <a style="text-decoration: none" href="#">2</a>
                                <a style="text-decoration: none" href="#">3</a>
                                <a style="text-decoration: none" href="#">4</a>
                                <a style="text-decoration: none" href="#">5</a>
                                </div>
                              </div>
                            </div>

                          </div>

                          <div class="col-sm">
                            
                            <h6 style="margin-top: 10%">
                               <strong>R$
                              {{product.price}}
                             </strong>
                            </h6>

                          </div>

                          <div class="col-sm">
                            
                            <RemoveToCart @click="updatePrice()" :product="product"/>

                          </div>
                          
                        </div>
                      </div>                 
                    </div>
                  </div>
                  <hr>
                </ul>
              </div>

              <div style="height:120px" class="card-footer">
                <div id="simulator" class="col-md-7">
                        <h4>Calcular frete e prazo:</h4>
                        <b-input-group>
                        <b-form-input
                          type="tel"
                          class="input-text cep-number"
                          placeholder="00000-000"
                          maxlength="9"
                          id="zipcode"
                          name="zipcode"
                          value
                        />
                        <b-button primary="outline" class="button" type="submit">Ok</b-button>
                        </b-input-group>
                      </div>
              </div>
            </div>
          </div>
        </div>

        <div class="purchase-information">
          <b-card-group>
            <b-card style="max-width:25rem; min-width: 23rem; background-color: rgb(213, 213, 213)" class="card-left">
              <h5>Resumo da compra R$</h5>
              <h5>Subtotal (Qtd. Produtos)</h5>
              <h5>Frete</h5>
              <hr>
              <h4>TOTAL</h4>
              <h5 style="font-size: 19px">R$ {{getsumtotal}} em 1x no Boleto Bancário</h5>
              <h5 style="font-size: 19px">R$ {{getsumtotal}} em 1x no Boleto Bancário</h5>
            </b-card>
          </b-card-group>

          <b-button
            style="background-color:#033076; height: 15%; margin-top: 1%; margin-bottom: 5%"
            type="submit"
            block
            variant="primary"
          >
            <i class="fas fa-cart-plus" style="font-size:100%">Continuar Compra</i>
          </b-button>
        </div>
      </section>
    </div>

    <div v-else style="color: #C0C0C0; font-style: italic; max-width:100%">
      <router-link style="text-decoration: none;" to="/">
        <h2 style="color: #C0C0C0;margin-top:18%; min-width:100%; text-align:center; font-size:4em" >
          Vamos as compras...
          <i
            class="fas fa-wind fa-flip-horizontal fa-flip-vertical"
            style=" color: #eaeaea;"
          ></i>

          <i class="fas fa-running"></i>
        </h2>
      </router-link>
      
    </div>
     
   
  </div>
</template>

<script>
/eslint no-console: "error"/;
/* eslint-disable */
import MainBar from "../components/shared/MainBar";
import RemoveToCart from "../components/ProductComponents/RemoveToCart";

import { mapState, mapActions, mapMutations, mapGetters } from "vuex";
export default {
  name: "PageBag",

  data() {
    return {
      products: [],
      value: "",
      subTotal: 0
    };
  },

  methods: {
    sum(e) {
      if (this.value <= 9) {
        this.value++;
      } else {
        this.value = value;
      }
    },
    decrease(e) {
      if (this.value >= 2) {
        this.value--;
      } else {
        this.value = value;
      }
    },
    hasProduct() {
      return this.getProductsInCart.length > 0;
    }
  },

  components: {
    MainBar,
    RemoveToCart,
 
  },

  created() {
    this.products = this.getProductsInCart;
  },
  computed: {
    ...mapGetters(["getProductsInCart", "getsumtotal"])
  }
};
</script>

<style >
.my-basket {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1q2rem;
  margin-top: 3%;
  color: #033076;
  margin-left: 4%;
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
  margin-top: 3.5%;
  margin-right: 5%;

}

.quantity {
  float: left;
  margin-right: 15px;
  background-color: #111;
  position: relative;
  width: 70px;
  overflow: hidden;
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
  background-color: #d5d5d5;
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
  background-clip: padding-box;
}

.quantity .minus,
.quantity .plus {
  line-height: 0;
  background-clip: padding-box;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0;
  -webkit-background-size: 6px 30px;
  -moz-background-size: 6px 30px;
  color: #111;
  font-size: 20px;
  position: absolute;
  height: 50%;
  border: 0;
  right: 0;
  padding: 0;
  width: 25px;
  z-index: 3;
}

.quantity .minus:hover,
.quantity .plus:hover {
  background-color: #dad8da;
}

.quantity .minus {
  bottom: 0;
}
.shopping-cart {
  margin-top: 20px;
}
.card-left {
  border: none;
}
.item-left {
  width: 100%;
  padding: 5%;
  border-left: none;
  border-right: none;
}
.button {
  border-color: #033076;
  color: #fff;
  background-color: #033076;
  margin-left: 7px;
  
}
.inputQuantity {
  width: 40px;
}
.minus {
  width: 20px;
  background-color: #DADADA;
  border-radius: 100%;
  margin-left: 1px;
}
.plus {
  width: 20px;
  background-color: #DADADA;
  border-radius: 100%; 
  margin-left: 2px;
}
.dropbtn {
  background-color: #033076;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  height: 39px;
  border-radius: 9%; 
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 40px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #033076;
}
</style>