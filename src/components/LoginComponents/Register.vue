<template>
    <div>
        <NavBar></NavBar>

         <b-card tag="article" class ="mb-2"  title="Cadastro" style="max-width:35rem">
          
             <b-form  @submit="checkErrors">
                <div
                    class="alert alert-danger"
                    role="alert"
                    v-for="(error, index) in errorMessage"
                    :key="index"
                    >
                    {{error}}
                </div>
                    
                <b-form-group id="email" label='Email' label-for="email"  >
                       <b-form-input class="input" type="email" v-model="user.email" name="email"  placeholder="Email"/>
                     
                </b-form-group>    

                  <b-form-group  id="senha" label='Senha' label-for="password" class="required-field">
                      <b-input-group >
                       <b-form-input :type="passwordFieldType" class="input"  maxlength="10" v-model="user.password" name="password"  placeholder="******* "/>
                    <b-input-group-btn >
                                 <i class="fas fa-eye-slash" style="position:absolute;right:3px;top:12px;visibility:visible;" @click="switchVisibility" ></i>
                    </b-input-group-btn>
                       
                       
                       </b-input-group>
                       
                  </b-form-group>  

                   

                     <b-form-group id="senha2" label="Repita a senha" label-for="password2" class="required-field">
                       <b-form-input class="input" type="password" maxlength="10" name="email2" v-model="user.password2" placeholder="******* "/>
                  </b-form-group>  

                    <b-button type="submit" block variant="primary" style="background-color:#033076" id="btn-register">Registrar</b-button>
                  
            </b-form>  

  
        </b-card>    
      </div>
</template>

<script>


import  NavBar from '../shared/LoginBar'
import api from '../../services/api';
/* eslint-disable */

export default {
    name :'Register',
   
    data(){
        return{
             passwordFieldType: 'password',
             user:{
                 email:'',
                 password:'',
                 password2:''
             },
            input:{
                errors: [],
                email:"",
                password:"",
                password2:""
            },
            fields : []
        }
    
    },  
    
    components:{
        NavBar
    },
    methods:{

        switchVisibility() {
                this.passwordFieldType = this.passwordFieldType === 'password' ? 'text' : 'password'
        },
        register(){
              let formData = new FormData()
                   formData.append('email', this.user.email);
                    formData.append('password', this.user.password);
            api.postUser(formData).then(Response => {
                    alert('adicionado com sucesso')
                    this.$router.push({name:'login'})
            }).catch(e => {
                console.log(e)
            })
        },

        checkErrors(e){
              
             
            if(this.user.email && this.user.password && this.user.password === this.user.password2) {
                if(this.user.password.length <= 5 && this.user.password2.length <= 5){
                
                    this.input.errors.push('senha com no minímo 5 digitos')
                    e.preventDefault();
                   
                  
                 }else{
                        this.register();
                        
                       
                 }

              
            }
          
            this.input.errors = [];    

           
            
            if(!this.user.email) 
                this.input.errors.push('O email é obrigatório');
            if(!this.user.password)
                 this.input.errors.push('a senha é obrigatória');
            if(!this.user.password2) 
                this.input.errors.push('por favor redigite a senha'); 
            if(this.user.password !== this.user.password2 || this.user.password > this.user.password2 || this.user.password2 > this.user.password)
                 this.input.errors.push('senhas não conferem');
          
            e.preventDefault();


           
           
         
           
            
            
        },
      

    }

        
    }


</script>


<style >
 

</style>

