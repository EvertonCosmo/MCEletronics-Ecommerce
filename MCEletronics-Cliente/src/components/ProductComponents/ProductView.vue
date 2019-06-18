<template>
<div>
  <MainBar :category="false"></MainBar>

        <b-container>
            <nav class="breadcrumb"> 
                <a href="#">Início</a>
                <span class="delimiter">
                    <i class="fa fa-angle-right"></i>
                </span>
                <a href="#">{{product.category}}</a>
                <span class="delimiter">
                     <i class="fa fa-angle-right"></i>
                </span>
                   {{product.name}}
            </nav>
        </b-container>
        <div id="content">
            <div>
                <div class="shopify-section">
                    <div class="single-product-area mt-80 mb-80">
                        <b-container>
                            
                            <b-row>
                                <div class="col-md-5">
                                    
                                                 <img :src="require(`/home/emanoel/Documentos/MCEletronics/MCEletronics-ADM/src/assets/${this.product.id}.jpg`)" width="100%" height="70%"/>
                                    <!-- END THUMBS -->

                                </div> 
                                    
                                <!-- END COL -->
                          
                                <b-card  tag="article" class="col-sm-7 product-actions" style="max-width:100%;" > 
                                <div class="availability">
                                    Disponibilidade: 
                                    <span><p class="stock in-stock">Em estoque</p></span> <!-- BIND CLASS -->
                                </div>
                                <b-card-body tag="article">
                                     <h3 class="title mb-3">{{product.name}}</h3>
                                     <p class="price-detail-wrap"> 

                                        <span class="price"> 
                                    
                                            <span class="currency"> R$ </span>
                                            <span class="num"> {{product.price}} </span>

                                        </span>

                                    </p>
                                    <hr >
                                    <b-form class="cart" action="#" method="post" enctype="multipart/form-data">

                                    <div class="quantity buttons_added">
                                        <input type="button" value="-" class="minus">
                                        <label for="quantity">Quantidade</label>
                                        <input style="width:100%" type="number" id="quantity" class="input-text qty text" step="1" min="1" max="50" name="quantity" value="1" title="Qt" size="4" pattern="[0-9]*" inputmode="numeric" aria-labelledby>       
                                        <input type="button" value="+" class="plus">
                                    
                                    </div>
                                    
                                    <span></span>    
                                

                                    <br>
                                    <b-button style="height:20%;width:70%;" primary="outline" type="submit" name="add-to-cart" values="90" class="cart-button button alt ">
                                        <i class="fas fa-shopping-cart"></i>  Comprar
                                    </b-button>
                                   
                                    

                                
                                <hr/>
                                <div id="simulator" class="col-md-7">
                                    <h3>Calcular frete e prazo:</h3>
                                   <input type="tel" class="input-text cep-number" placeholder="00000-000" maxlength="9" id="zipcode" name="zipcode" value="">
                                   <b-button primary="outline" class="button btn" type="submit">Ok</b-button>
                                   
                                    <div id="result" style="visibility:hidden;">
                                        <table class="table_f">
                                            <thead>
                                                <tr>
                                                    <th> Tipo de entrega </th>
                                                    <th> Custo </th>
                                                </tr>    
                                            </thead>
                                            <tbody>
                                                <tr> </tr>
                                            </tbody>
                                        </table>
                                    </div>


                                  
                                </div>
                                </b-form>
                                <div class="button-actions">
                                    <div>

                                    </div>
                                    <div class="clear">

                                    </div>
                                    
                                </div>
                                </b-card-body>
                                
                                </b-card>
                              
                            </b-row>   


                        </b-container>
                    </div>
                </div>
            </div>
       
        

    </div>




</div>

</template>


<script>
import MainBar from '../shared/MainBar'

export default {
    props:['product'],
    data(){
        return {
            // stock : this.product.quantity > 0
        }
    },
    components:{
        MainBar
    }
}



</script>



<style scoped>


    body, button, input, textarea {
        color: #333e48;
        font-family: open sans,HelveticaNeue-Light,helvetica neue light,helvetica neue,Helvetica,Arial,lucida grande,sans-serif;
        line-height: 1.714em;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-rendering: optimizeLegibility;
    }
.site-content {
    margin-bottom: 2.857em;
}

article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
    display: block;
}
button{
    touch-action: manipulation;
}
form {
    display: block;
    margin-top: 0em;
}
* {
    box-sizing: border-box;
}
.breadcrumb {
    background-color:transparent;
    margin-top: 1.786em;
      /* margin-left: 0%/ */
    margin-bottom: 2.571em;
}
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}
span.delimiter {
    margin: 0 1.429em;
}
.price {
    color: #333e48;
    font-size: 1.6em;
    line-height: 1.386em;
    font-weight: 400;
}
.cart {
    margin-bottom: 1.429em;
}
.input-text, input[type=email], input[type=password], input[type=search], input[type=text], input[type=url], textarea {
    padding: .857em 1.214em;
    background-color: transparent;
    color: #818181;
    line-height: 1.286em;
    outline: 0;
    border: 0;
    -webkit-appearance: none;
    border-radius: 1.571em;
    box-sizing: border-box;
    border-width: 1px;
    border-style: solid;
    border-color: #ddd;
}
input[type=submit] {
    font-weight: 700;
}
input[type=button]:hover{
    background-color: #000;
    border-color: #000;
}
div.quantity {
    margin-bottom: .714em;
}
div.quantity.buttons_added {
    position: relative;
}

.cart .quantity {
    display: inline-block;
    width: 10em;
}
div.quantity label {
    position: static;
    width: auto;
    height: auto;
    margin: 0;
    overflow: visible;
    clip: auto;
    font-weight: 400;
    margin-bottom: .714em;
    font-size: 1.5rem
}
label {
    font-size: 1em;
    line-height: 1.286em;
    font-weight: 700;
    margin-bottom: .857em;
    display: inline-block;
}
.quantity{
    background-color: transparent
}
div.quantity.buttons_added .minus, div.quantity.buttons_added .plus {
    width: 1.729em;
    height: 1.729em;
    border-radius: 50%;
    font-size: 1em;
    font-weight: 700;
    color: #333e48;
    padding: 0;
    text-align: center;
    line-height: 1.429em;
    position: absolute;
    bottom: .536em;
    right: .536em;
    display: inline-block;
}

div.quantity.buttons_added .plus {
    right: 1.965em;
    margin-right: .357em;
}
div.quantity.buttons_added .minus:hover, div.quantity.buttons_added .plus:hover {
    color: #fff;
}

.btn {
    display: inline-block;
     padding: 10px 20px;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    border: 1px solid transparent;
    border-radius: 55rem;
}
/* .single_add_to_cart_button.button {
    display: block;
    width: 100%;
    padding: 1.108em 2.134em;
    margin-bottom: .429em;
    margin-top: 1.429em;
    border-radius: 1.8em;
} */
.cart-button.button {
    display: block;
    width: 100%;
    padding: 1.108em 2.134em;
    margin-bottom: .429em;
    margin-top: 1.429em;
    border-radius: 1.8em;
}

form.cart .btn, form.cart .button {
    background: #033076;;
    color: #fff;
}
.button {
    border-color:  #033076;
    color:#fff;
    background-color: #033076
}
#simulator table{
    margin-top:15px;
}
table{
    width:100%;
    max-width: 100%;
    margin-bottom: 1.236rem;
    background-color: transparent;
    border-spacing: 0;
    border-collapse: collapse;
    border-color:grey;
}
thead {
    display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
}
.action-buttons {
    display: block;
    text-align: center;
    margin-bottom: 0;
}
.action-buttons>div {
    display: inline-block;
    margin: 0 5px;
    padding-top: .923em;
}
.product-actions {
    border: 2px solid #ddd;
    border-radius: 1.214em;
    padding: 0em 0em 0em 0.5em;
}
.product-actions div.availability {
    display: block;
    padding-bottom: .714em;
    border-bottom: 1px solid #ddd;
    margin-bottom: 1.429em;
    vertical-align: middle;
    color: #8f8e94;
}
.availability p.stock {
    display: inline;
}
.in-stock span, p.in-stock {
    color: #5cb85c;
}

</style>

