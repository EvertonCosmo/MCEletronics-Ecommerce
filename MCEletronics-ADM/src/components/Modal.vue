<template>
<div class="container" v-if="edit">
   <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
               <h1> Editar Produto</h1> {{product.name}}
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              
      <form class="md-layout" @submit.prevent ="updateProduct">

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
            <b-input type="text" v-model="product.name" :value="product.name" placeholder="Nome"  required ></b-input>
        

        
          <label>Quantidade</label>
          <b-input type="number" v-model="product.quantity"  :value="product.quantity"  placeholder="Quantidade" step="1" min="1" pattern="[0-9]*" inputmode="numeric"  required></b-input>
          

          
          <label>Categoria</label>
          <b-form-select v-model="product.category"  :value="product.category" :options="options"> </b-form-select>
           
          <label>Preço</label>
           <div>
          <money v-model="product.price" v-bind="money" class="form-control"></money> 
          </div>
            <br>
           <label>Imagem do Produto</label>
            <!-- <vue-dropify style="width:20%;" v-model="product.photo" required></vue-dropify> -->
            <b-form-file accept="image/*"  v-model="file" id="file" name="image" ref="file" @change="handleFileUpload()"></b-form-file>
          
            <br> 
            <br>
            <b-textarea v-model="product.description" maxlength="150"  :value="product.description" placeholder="descrição do produto">

            </b-textarea>
           
             <b-button type="submit"  style="margin-top:3% " class="float-right" variant="primary">
                 Atualizar<i class="material-icons" alt="Atualizar">save</i></b-button>
           
                 

          </form>

            </slot>
             <b-row class="modal-footer">
            <slot name="footer">
                     
                
                </slot>
               
          </b-row>
            <b-button variant="primary" class="" @click="$emit('close')" style="margin-top:-1%">
                                  Fechar
                       </b-button>   
          </div>

     
        </div>
      </div>
    </div>
  </transition>
</div>



<div class="container" v-else>
 <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
              <h2>{{product.name}}</h2>
              
            </slot>

            
          </div>


            <b-row class="modal-body">
              <div class="col-md-6" role="main">
                  <slot name="body">
                     
                 	 <b><p> Id: {{product.id}} </p></b>
                 	
                    <p> Quantidade: {{product.quantity}}</p>
                   <p> Categoria: {{product.category}}</p>
                   <br><br>
      			       <h2><p>Preço: R$ {{product.price}}</p></h2>

                  </slot>

              </div>


            <aside role="complementary" class="col-md-4">
               
                        <img :src="require(`/home/emanoel/Documentos/MCEletronics/backend-MCEletronics/api/images/${this.product.id}.jpg`)" height="100%" width="100%"/>
                  
            </aside>
          </b-row>
          <hr>
          <div class="modal-body">
             <p> Descrição: {{product.description}}</p>
          </div>
          <b-row class="modal-footer">
            <slot name="footer">
                       <b-button variant="primary" @click="$emit('close')">
                                  Fechar
                       </b-button>   
                
                </slot>
               
          </b-row>
         
        </div>
      </div>
    </div>
  </transition>
</div>


</template>

<script>
  import ProductService from "../services/products.js"
  import {Money} from 'v-money'
	export default{
		name:'Modal',
		props: {
      product: Object,
      edit:Boolean,
      options:Array
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
          file: null,
          id:this.product.id,
          dismissSecs: 3,
          dismissCountDown: 0,
          variant:'',
          message:'',
      }
    },
    methods:{
        countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
       showAlert() {
        this.dismissCountDown = this.dismissSecs
      },
      updateProduct(){
                       let formData = new FormData()
                    formData.append('name', this.product.name);
                    formData.append('category', this.product.category);
                    formData.append('price', this.product.price);
                    formData.append('quantity', this.product.quantity);
                    formData.append('description', this.product.description);
                     formData.append('image', this.file);
            ProductService.update(formData,this.id).then(Response => {
                console.log(Response.data);
                // this.product = {}
                // alert("adicionado com sucesso")
                // this.showAlert()
                this.variant = "primary"
                this.message = "Atualizado com sucesso"
                // alert("adicionado com sucesso")
                this.showAlert()
            }).catch(e => {
             this.variant = "warning"
                this.message = "Erro ao atualizar"
                this.showAlert()
                console.log(e)
            })
                    

        },
      handleFileUpload(){
             this.file = this.$refs.file.files[0];
        },
 

    
    },
}

</script>
<style >

	.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 70%;
  margin: 0px auto;
  /*padding: 20px 30px;*/
  padding: 5% ;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;
  overflow-y: auto;
  max-height: 90%;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
	
</style>