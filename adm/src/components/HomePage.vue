<template>
<div>
    <main-bar></main-bar>


    <div class="container">

        <ul>
         <li v-for="(erro, index) of errors" :key="index">
          campo <b>{{erro.field}}</b> - {{erro.defaultMessage}}
         </li>
        </ul>

      <form class="md-layout" @submit.prevent ="saveProduct">

<b-alert :show="dismissCountDown"
              dismissible
              :variant="variant"
              @dismissed="dismissCountDown=0"
              @dismiss-count-down="countDownChanged"
              class="fixed-bottom"
              style="width: 35%; "
              >

              {{message}}
      </b-alert>
             
  
     
             <label>Nome</label>
            <b-input type="text" v-model="product.name" placeholder="Nome"  required ></b-input>
        

           
        
             <label>Código de barras</label>
             <b-input type="text" maxlength="10" placeholder="Identificação" required></b-input>
       

       
          <label>Quantidade</label>
          <b-input type="number" v-model="product.quantity" placeholder="Quantidade" value="1" step="1" min="1" pattern="[0-9]*" inputmode="numeric"  required></b-input>
          

          
          <label>Categoria</label>
          <b-form-select v-model="product.category" :options="options"> </b-form-select>
           
          <label>Preço</label>
          <!-- <b-input type="text" v-model="product.price" placeholder="Preço"  inputmode="numeric"  pattern="[0-9]*" required></b-input> -->
          <!-- <v-currency-field label="Value" v-bind="currency_config" :error-messages="errors.price" v-model="product.price"></v-currency-field> -->
         <div>
          <money v-model="product.price" v-bind="money" class="form-control"></money> 
          </div>

            <br>
           <label>Imagem do Produto</label>
            <!-- <vue-dropify style="width:20%;" v-model="product.photo" required></vue-dropify> 
              ADD MORE PHOTOS 
            --> 
            <b-form-file accept="image/*"  v-model="product.file" id="file" name="image" ref="file" @change="handleFileUpload()"></b-form-file>
          
            <br> 
            <br>
            <b-textarea v-model="product.description"  maxlength="150" placeholder="descrição do produto">

            </b-textarea>
           
             <b-button type="submit"  style="margin-top:3% " class="float-right" variant="primary">
                 Salvar<i class="material-icons" alt="salvar">save</i></b-button>
           
                 

</form>
      <table  style="width:100%" v-show="load" class="table table-responsive">
                <thead>
                      <tr>
                          <th>id</th>
                          <th>Nome</th>
                          <th>Categoria</th>
                          <th>Preço</th>
                          <th>Quantidade</th>
                          <th>Opções</th>
                   
                      </tr>
                </thead>
                  
                <tbody  >
                      <tr :key="product.id" v-for="product in products">
                            <td>{{product.id}}</td>
                            <td>{{product.name}}</td>
                            <td>{{product.category}}</td>
                            <td>{{product.price}}</td>
                            <td>{{product.quantity}}</td>
                            <td>
                                 <!-- <router-link :to="{ name:'product-view', params: {id: product.id} } "> -->
                                  <b-button @click ="show(product)" alt="ver" style="margin: 1%" variant="primary" ><i class="material-icons">vignette</i></b-button>
                                  <Modal id="my-modal" v-if="modalShow" @close ="modalShow = false" 
                                         :product="product_modal" :edit="edit">
                                    
                                  </Modal>
                                  <!-- </router-link> -->
                                
                                  <b-button @click="editModal(product)" style="margin: 1%" alt="editar" variant="primary" ><i class="material-icons">create</i></b-button>
                                   <Modal id="my-modal" v-if="modalShow" @close ="modalShow = false" 
                                         :product="product_modal" :edit="edit" :options="options">
                                    
                                  </Modal>
                                
                                <b-button   @click="remove(product.id)" variant="danger" alt="remover" ><i class="material-icons">delete_sweep</i></b-button>
                           
                               
                            </td>
                      </tr>
                </tbody>
                  
              </table>


    </div>
</div>
</template>


<script>
import axios from "axios";
import MainBar from "./MainBar"
import ProductService from "../services/products.js"
import Modal from "./Modal"
import {Money} from 'v-money'
// import VueDropify from  "vue-dropify"


export default {
    name:"HomePage",
    components:{
        MainBar,Modal
        //  'vue-dropify': VueDropify 
        
    },
    data(){
        return{
          
          money: {
            decimal: ',',
            thousands: '.',
            prefix: 'R$ ',
            precision: 2,
            masked: false,
          },
            load:false,
            modalShow: false,
            edit:false,
            dismissSecs: 3,
            dismissCountDown: 0,
            variant:'',
            message:'',
            product: {
               file:null,
                // id:'',
                name:'',
                price:'',
                category:'',
                quantity:'',
                description:'',
              
            },
            product_modal : {
                file:null,
                name:'',
                price:'',
                category:'',
                quantity:'',
                description:'',
            },

            
            options:[ 
                {value:"Eletronico",text:"Eletrônico"},
                {value:"Placa",text:"Placa"},
                {value:"Iniciante",text:"Iniciante"},
                {value:"Som",text:"Som"},
                {value:"Música",text:"Musica"}
            ],

            products:[],
            errors:[]
          }
    },
    methods: {
       countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
       showAlert() {
        this.dismissCountDown = this.dismissSecs
      },
        getProducts(){
            ProductService.get().then(Response => {
                if(Response.data.product.length > 1){
                   this.products = Response.data.product;
                   this.load = true;
                }else{
                    this.products = Response.data;
                    this.load = true;
                }

            }).catch(e =>{
                console.log(e)
            })
 


          },
      show(product){
        this.product_modal = product;
        this.edit = false;
        this.modalShow = true;


      } ,
      editModal(product){
         this.product_modal = product;
         this.edit = true;
         this.modalShow = true;
      },
        saveProduct(){
            let formData = new FormData()
                   formData.append('image', this.product.file);
                    formData.append('name', this.product.name);
                    formData.append('category', this.product.category);
                    formData.append('price', this.product.price);
                    formData.append('quantity', this.product.quantity);
                    formData.append('description', this.product.description);
            ProductService.post(formData).then(Response => {
                console.log(Response.data);
                this.product = {}
                this.variant = "primary"
                this.message = "Adicionado com sucesso"
                // alert("adicionado com sucesso")
                this.showAlert()
                this.getProducts()
            }).catch(e => {
                this.variant = "warning"
                this.message = "error"
                this.showAlert()
                console.log(e)
            })
                    
                  

            
        },
        remove(index){
        
          
            if(confirm("Deseja remover o produto ? ")){

              ProductService.delete(index).then(Response => {
                this.variant = "warning"
                this.message = "removido com sucesso"
                this.getProducts()
                this.showAlert()
              }).catch(e=>{
                console.log(e)
              })
            }
      

        },
         handleFileUpload(){
             this.product.file = this.$refs.file.files[0];
        }

    },
    

    mounted(){
        this.getProducts()
    }
    
}
</script>

<style scoped>

/**
 * Remove the inheritance of text transform in Edge, Firefox, and IE.
 * 1. Remove the inheritance of text transform in Firefox.
 */
button,
select {
  /* 1 */
  text-transform: none;
}
/**
 * 1. Prevent a WebKit bug where (2) destroys native `audio` and `video`
 *    controls in Android 4.
 * 2. Correct the inability to style clickable types in iOS and Safari.
 */
button,
html [type="button"],
[type="reset"],
[type="submit"] {
  -webkit-appearance: button;
  /* 2 */
}

/**
 * Remove the inner border and padding in Firefox.
 */
button::-moz-focus-inner,
[type="button"]::-moz-focus-inner,
[type="reset"]::-moz-focus-inner,
[type="submit"]::-moz-focus-inner {
  border-style: none;
  padding: 0;
}

/**
 * Restore the focus styles unset by the previous rule.
 */
button:-moz-focusring,
[type="button"]:-moz-focusring,
[type="reset"]:-moz-focusring,
[type="submit"]:-moz-focusring {
  outline: 1px dotted ButtonText;
}


.input-field input[type=text]:focus + label {
     color: #000;
}

 .input-field input[type=number]:focus {
     border-bottom: 1px solid#033076;
     box-shadow: 0 1px 0 0 #033076;
   }
/* label underline focus color */
   .input-field input[type=text]:focus {
     border-bottom: 1px solid #033076;
     box-shadow: 0 1px 0 0 #033076;
   }

</style>

