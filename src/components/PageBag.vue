<template>
  <div>
        <!-- <BarInfo></BarInfo> -->
    <main-bar></main-bar>

    <section style="width: 100%;padding: 0px 0px 2% 0px" >
          
      <div style="width: 50%; height: 50px;">
        <b-navbar-brand class="my-basket">Minha Cesta <i class="fas fa-shopping-basket" style="margin-left: 5%"></i> </b-navbar-brand>
      </div>

      <div class="selection-box" style="max-width: 55rem; width: 100%; display: block" >
        
          <div class="container">
           <div class="card shopping-cart">
            <div class="card-body">
                    <!-- PRODUCT -->
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-2 text-center">
                                <img class="img-responsive" src="http://placehold.it/120x80" alt="prewiew" width="120" height="80">
                        </div>
                        <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                            <h4 class="product-name"><strong>Product Name</strong></h4>
                            <h4>
                                <small>Product description</small>
                            </h4>
                        </div>
                        <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                            <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                                <h6><strong>25.00 <span class="text-muted">x</span></strong></h6>
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
                    <!-- END PRODUCT -->
                    <!-- PRODUCT -->
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-2 text-center">
                                <img class="img-responsive" src="http://placehold.it/120x80" alt="prewiew" width="120" height="80">
                        </div>
                        <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                            <h4 class="product-name"><strong>Product Name</strong></h4>
                            <h4>
                                <small>Product description</small>
                            </h4>
                        </div>
                        <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                            <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                                <h6><strong>25.00 <span class="text-muted">x</span></strong></h6>
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
                    <!-- END PRODUCT -->
               
            </div>
            <div class="card-footer">
                <div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
                    <div class="row">
                        
                             <h5>Calcular frete e prazo:</h5>
                        
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="00000-000">
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
      </div>

      <div class="purchase-information" style="max-width: 25rem; width: 100%; display: block" >       
        <div style="background-color: rgb(176, 177, 179); height:270px">
            <!-- çç -->
        </div>

        <b-button v-if="!loading" style= "background-color:#033076; height: 15%; margin-top: 2%;" type="submit"  block variant="primary">
          <i class="fas fa-cart-plus" style="font-size:100%"> Continuar Compra</i> 
        </b-button>
      </div>

    </section>

  </div>

</template>

<script>

  import MainBar from "../components/BarComponents/MainBar.vue";
  export default {
    name: "PageHome",

    components: {
      MainBar
    },

    data() {
      return {
        // Note `isActive` is left out and will not appear in the rendered table
        fields: ['first_name', 'last_name', 'age'],
        items: [
          { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
          { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
          { age: 89, first_name: 'Geneva', last_name: 'Wilson' },
          { age: 38, first_name: 'Jami', last_name: 'Carney' }
        ]
      }
    }

  }

</script>

<style>

.my-basket {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 300%; 
  margin-top:3%;
  color: #033076;
  margin-left:4%;
}

.selection-box {
  /* background-color: rgb(176, 177, 179); */
  width: 60%;
  margin-top: 4%;
  margin-left: 1%;
  margin-right: 1%;
  height: 540px;
  float: left;
}  

.purchase-information {
  float: right;
  width: 30%;
  margin-top: 4%;
  margin-left: 1%;
  margin-right: 1%;
  height: 300px;
}

.basket-columns {
  display: flex;
  padding: 1rem 1rem 0.1rem 0rem;
  /* border-bottom: 1px solid #4e4e66; */
}

.basket-column {
  margin: 0;
  color: #4a4a4a;
  font-size: 18px;
  line-height: 16px;
  width: calc((100% - 85px - 1rem) * .19);
}

.quantity {
    float: left;
    margin-right: 15px;
    background-color: #eee;
    position: relative;
    width: 80px;
    overflow: hidden
}

.quantity input {
    margin: 0;
    text-align: center;
    width: 15px;
    height: 15px;
    padding: 0;
    float: right;
    color: #000;
    font-size: 20px;
    border: 0;
    outline: 0;
    background-color: #F6F6F6
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


</style>