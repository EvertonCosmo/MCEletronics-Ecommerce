<template>
    <div>
        <NavBar></NavBar>

         <b-card tag="article" class ="mb-2"  title="Cadastro" style="max-width:25rem">
          
             <b-form  @submit="checkErrors">

                <p v-show="input.errors.length ">
                    <b>Por favor, corrija o(s) seguinte(s) erro(s):</b>
                     <ul>
                      <li :key="error.value" v-for="error in input.errors">{{ error }}</li>
                     </ul>
                 </p>
                    
                <b-form-group id="email" label='Email' label-for="email" class="required-field" >
                       <b-form-input class="input" type="email" v-model="input.email" name="email"  placeholder="Email"/>
                </b-form-group>    

                  <b-form-group id="senha" label='Senha' label-for="password" class="required-field">
                       <b-form-input class="input" type="password" v-model="input.password" name="password"  placeholder="******* "/>
                  </b-form-group>  

                   

                     <b-form-group id="senha2" label="Redigite a senha" label-for="password2" class="required-field">
                       <b-form-input class="input" type="password" name="email2" v-model="input.password2" placeholder="******* "/>
                  </b-form-group>  

                    <b-button type="submit" block variant="primary" style="background-color:#033076" id="btn-register">Registrar</b-button>
                  
            </b-form>  

  
        </b-card>    
      </div>
</template>

<script>
import  NavBar from './NavBar'

export default {
    name :'Register',
    data(){
        return{
            input:{
                errors: [],
                email:"",
                password:"",
                password2:""
            }
        }
    },  
    components:{
        NavBar
    },
    methods:{
        checkErrors(e){
            if(this.input.email && this.input.password && this.input.password === this.input.password2){
                return true;
            }
            this.input.errors = [];    

            if(!this.input.email){
                this.input.errors.push('O email é obrigatório');
            }
            if(!this.input.password){
                this.input.errors.push('a senha é obrigatório');
            }
            if(!this.input.password2){

                this.input.errors.push('por favor redigite a senha');
            }
            if(this.input.password !== this.input.password2){
                this.input.errors.push('senhas não conferem');
            }
 
            e.preventDefault();

            
            
        }


    }

        
    }


</script>


<style >
 

</style>

