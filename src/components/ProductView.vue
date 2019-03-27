<template>

        <b-card class="gallery-wrap " style="max-width:55rem" >
            <b-row>     
                    <aside class="col-sm-5 border-right" >
                            <div class="img-big-wrap">
                                <a href=""><img  id="item-display" src="../assets/arduinoMain.png" alt="arduino"></a>
                            </div>

                    <div class="img-small-wrap"> <!-- img small -->
                        <div class="item-gallery"><img  src="../assets/arduinoMain.png" alt="arduino"></div>
                        <div class="item-gallery"> <img  src="../assets/arduinoMain.png" alt="arduino"> </div>
                        <div class="item-gallery"><img  src="../assets/arduinoMain.png" alt="arduino"> </div>
                        <div class="item-gallery"> <img  src="../assets/arduinoMain.png" alt="arduino"></div>


                    </div>

                  </aside>

              
       
                  
  
                <aside > 
                    <!-- product information -->
                    <div class ="mb-2" tag="article" style="margin-right:30%; max-width:100%;" >
                        <b-card-body >
                            <h3>Arduino Uno - R3</h3>

                        <p > 

                                <span class="price h3 text-warning"> 
                                   
                                <span class="currency">R$ </span>
                                <span class="num">300,00</span>
                                
                                </span>
                        </p>       



                       
                     
                       <!-- <b-button-group style= "background-color:#033076; float:right;margin-top:5%; margin-right:-60%; max-width:100%;"> -->
                                    <b-button block primary="outline" class="float-right" style="background-color:#033076;">Comprar </b-button>
                        <!-- </b-button-group> -->
                        <br>
                        
                        <hr style="max-width:100%"> 

                        <!-- Credit Card -->
                         <p class="price-detail-wrap"> 

                                <span> 
                             <i class="far fa-credit-card" style="margin-right:10px"></i>      
                                <span class="currency">R$ </span>
                                <span class="num">14,00</span>
                                
                                </span>
                        </p>  
                            <!--  Boleto -->
                         <p class="price-detail-wrap"> 
                                
                                <span > 
                                    <i class="fas fa-file-alt" style="margin-right:10px"></i> 
                                <span class="currency"> R$ </span>
                                <span class="num">14,00</span>
                                
                                </span>
                        </p>  

                        
                    </b-card-body>
                     </div>
                     </aside>
                    
            </b-row>
                    </b-card>

                        

                           
                
    
          






     

   
                  
</template>

<script>
export default {
    name:'ProductView',

   
    components:{

    }
}
</script>

<style>
/* #item-display{
    width: 20%;
    height: 20%;
} */

.gallery-wrap .img-small-wrap .item-gallery {
    width: 15%;
    height: 6%;
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
    margin-top:1%;
}
.gallery-wrap .img-small-wrap img {
    max-width: 100%;
    max-height: 100%;
    /* object-fit: cover; */
    border-radius: 4px;
    cursor: zoom-in;
}
</style>
