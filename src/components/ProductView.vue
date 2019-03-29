<template>
<div>
        <main-bar></main-bar>

        <b-card tag="article" class="gallery-wrap " style=" margin-top:20px; border:none;max-width:60rem;height:40rem;" >
            <b-row >     
                    <aside class="col-sm-5 border-right" >
                            <div class="img-big-wrap">
                                <a href=""><img  id="item-display" src="https://www.raspberrypi.org/app/uploads/2017/05/Raspberry-Pi-3-462x322.jpg" alt="arduino"></a>
                            </div>

                    <div class="img-small-wrap"> <!-- img small -->
                        <div class="item-gallery"><img  src="../assets/Raspberry-Pi-3-462x322.jpg" alt="raspberry"></div>
                        <div class="item-gallery"> <img src="../assets/Raspberry-Pi-3-462x322.jpg" alt="raspberry"> </div>
                        <div class="item-gallery"><img  src="../assets/Raspberry-Pi-3-462x322.jpg"  alt="raspberry"> </div>
                        <div class="item-gallery"> <img  src="../assets/Raspberry-Pi-3-462x322.jpg" alt="raspberry"></div>
                    </div>

                  </aside>
        
              
       
                  
  
                <b-card tag="article" class="col-sm-7" style="max-width:100%;height:50%" > 
                    <!-- product information -->
                   
                        <b-card-body tag="article">

                            <h3 class="title mb-3">Raspberry Pi 3</h3>

                        <p class="price-detail-wrap"> 

                                <span class="price h3 text-warning"> 
                                    
                                    <span class="currency"> R$ </span>
                                    <span class="num"> 300,00 </span>
                                
                                </span>
                        </p>       
                     
                                    <b-button block primary="outline" class="float-right" style="background-color:#033076;"> <i class="fas fa-shopping-cart"></i>   Comprar </b-button>
                                    <b-button block primary="outline" class="float-right" style="background-color:#033076;"><i class="fas fa-heart"></i>   Lista de Desejo </b-button>
                       
                        <br>
                        <br>
                        
                        <br>
                        <br>
                        <hr style="max-width:50rem"> 

                        <!-- Credit Card -->
                         <p class="price-detail-wrap"> 

                                <span> 
                             <i class="far fa-credit-card" style="margin-right:10px"></i>      
                                <span class="currency">R$ </span>
                                <span class="num">14,00 1 x no cartão de crédito</span>
                              
                                
                                </span>
                        </p>  
                            <!--  Boleto -->
                         <p class="price-detail-wrap"> 
                                
                                <span > 
                                <i class="fas fa-file-alt" style="margin-right:10px"></i> 
                                <span class="currency"> R$ </span>
                                <span class="num">14,00 1 x no boleto </span>
                                
                                </span>
                        </p>  

                        
                    </b-card-body>
                <label style="margin-left:25%;;margin-bottom:0%">Calcular frete</label>
                <p></p>
                 <b-form-group id="cep" style="margin-left:50%;margin-top:-5%;">
                          <b-form-input class="input" type="text" maxlength="9" style="max-width:100%" name="input" placeholder="CEP"/>
                          <b-button variant="primary"  style="position:absolute; left:85%; top:84.1%" class="float-right">OK</b-button>
                </b-form-group>  
                </b-card>
                    
                    
                
                                 
                            
                   
                    <br><br>
                   <h3 style="color:#033076">Informações do Produto</h3>
                   <dl class="text-justify " >
                      <dd> <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Voluptas, aspernatur fugit. Dolores, repellendus asperiores. Dolore, minima atque architecto unde voluptate voluptatem similique eveniet aut est fugiat. Dolores dolorem veniam ullam.
                       Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est atque, explicabo ipsa aperiam facere voluptates quod, nostrum id eum perferendis asperiores error tenetur laboriosam culpa ut accusantium et voluptas esse.
                       Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt beatae molestias adipisci sed et iste praesentium reprehenderit! In, corporis harum, asperiores fuga, velit quam iusto dicta similique hic necessitatibus iure.
                       
                       </p></dd>
                   </dl>

                   <!-- Área de avaliação -->
                </b-row>
                
            </b-card>

                        
</div>
                           
                
     

   
                  
</template>

<script>

import MainBar from './MainBar.vue'

export default {
    name:'ProductView',

   
    components:{
        MainBar
    }
}
</script>

<style scoped>
/* #item-display{
    width: 20%;
    height: 20%;
} */


.gallery-wrap .img-small-wrap .item-gallery {
    width: 15%;
    height:1%;
    border: 1px solid #ddd;
    margin: 5px 1px 20px 10px;
    display: inline-block;
    /* overflow: hidden; */
}

.gallery-wrap  aside div.img-big-wrap img {
    height: 100%;
    width: 100%;
    display: inline-block;
    cursor: zoom-in;
}
.gallery-wrap .img-small-wrap {
    text-align: center;
    margin-right: 0%;
    margin-top:20%;
}
.gallery-wrap .img-small-wrap img {
    max-width: 100%;
    max-height: 100%;
    /* object-fit: cover; */
    border-radius: 4px;
    cursor: zoom-in;
}
</style>
