<template>
    <div>
        <NavBar></NavBar>

         <b-card tag="article" class ="mb-2"  title="Cadastro" style="max-width:35rem">
          
             <b-form  @submit.prevent="createAccount">
                <div
                    class="alert alert-danger"
                    role="alert"
                    v-for="(error, index) in errorMessage"
                    :key="index"
                    >
                    {{error}}
                </div>
                    
                <b-form-group id="username" label='Nome de Usuário' label-for="username"  >
                       <b-form-input class="input" type="text" v-model="user.username" name="username"  placeholder="Nome de Usuário"/>
                     
                </b-form-group>    

                  <b-form-group  id="senha" label='Senha' label-for="password" class="required-field">
                      <b-input-group >
                       <b-form-input :type="passwordFieldType" class="input"  maxlength="10" v-model="user.password" name="password"  placeholder="******* "/>
                    <b-input-group-btn >
                                 <i class="fas fa-eye-slash" style="position:absolute;right:3px;top:12px;visibility:visible;" @click="switchVisibility" ></i>
                    </b-input-group-btn>
                       
                       
                       </b-input-group>
                       
                  </b-form-group>  

                   

                     <b-form-group id="passowrd2" label="Repita a senha" label-for="password2" class="required-field">
                       <b-form-input class="input" type="password" maxlength="10" name="email2" v-model="passwordcomparation" placeholder="******* "/>
                  </b-form-group>  

                    <b-button type="submit" block variant="primary" style="background-color:#033076" id="btn-register">Registrar</b-button>
                  
            </b-form>  

  
        </b-card>    
      </div>
</template>

<script>


import  NavBar from '../shared/LoginBar'
import api from '../../services/api';
import {successToaster, errorToaster} from "../../services/ErrorHandler.js";
/* eslint-disable */

export default {
    name :'Register',
   
    data(){
        return{
             passwordFieldType: 'password',
             user:{
                 username:'',
                 password:''
             },
             errorMessage: [],
            passwordcomparation:''
            
        }
    
    },  
    
    components:{
        NavBar
    },
    methods:{
        // ValidateEmail(email) {
        //     if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        //         return true;
        //     }
      
        //     return false;
        // },

        switchVisibility() {
                this.passwordFieldType = this.passwordFieldType === 'password' ? 'text' : 'password'
                
        },
      
        checkForm(){
            this.errorMessage =  []
            if(this.user.password.length < 5){
                this.errorMessage.push('Senha deve conter mais de 5 digitos')
            }
            if(this.user.username.length < 5){
                this.errorMessage.push('Nome deve conter mais de 5 caracteres')
               
            }

            if(this.user.password != this.passwordcomparation){
                this.errorMessage.push('Senhas não conferem')
               
            }
            console.log(this.errorMessage.length)
        },
        createAccount(e){
            
            this.checkForm();
          
            if(this.errorMessage.length == 0){

                let formData = new FormData();
                formData.append('username',this.user.username);
                formData.append('password',this.user.password);

                api.postUser(formData).then(Response => {
                    if(Response.status == 200){
                        console.log(Response.data)
                        successToaster(
                            "Cadastrado com sucesso",
                            "Usuário cadastrado com sucesso"  
                        );
                        this.$router.push({name:'login'})

                    }else{
                        console.log(Response.data)
                    }
                
                }).catch(e => {
                    console.log(e)
                    if(e.response.status == 400){
                        errorToaster(
                            "Usuário já cadastrado",
                            "Já cadastrado"
                         );
                        
                         
                        
                    }else{
                        errorToaster(
                            "Falha no cadastro",
                            "Tente novamente mais tarde"
                         ); 
                    }

                })
                           
            }else {
                
                this.checkForm()

            }


            

           
        }

        
    }
}


</script>


<style >
 #toast-container > div {
  opacity: 1;
}
.toast {
  font-size: initial !important;
  border: initial !important;
  backdrop-filter: blur(0) !important;
}
.toast-success {
  background-color: #51A351 !important;
}
.toast-error {
  background-color: #BD362F !important;
}
.toast-info {
  background-color: #2F96B4 !important;
}
.toast-warning {
  background-color: #F89406 !important;
}

</style>

