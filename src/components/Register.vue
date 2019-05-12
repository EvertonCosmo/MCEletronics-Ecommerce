<template>
    <div>
        <NavBar></NavBar>

         <b-card tag="article" class ="mb-2"  title="Cadastro" style="max-width:25rem">
          
             <b-form  @submit="checkErrors">

                <p v-show="input.errors.length ">
                    <b>Por favor, corrija o(s) seguinte(s) erro(s):</b>
                     <ul>
                      <li :key="error" v-for="error in input.errors">{{ error }}</li>
                     </ul>
                 </p>
                    
                <b-form-group id="email" label='Email' label-for="email"  >
                       <b-form-input class="input" type="email" v-model="input.email" name="email"  placeholder="Email"/>
                     
                </b-form-group>    

                  <b-form-group  id="senha" label='Senha' label-for="password" class="required-field">
                      <b-input-group >
                       <b-form-input :type="passwordFieldType" class="input"  maxlength="10" v-model="input.password" name="password"  placeholder="******* "/>
                    <b-input-group-btn >
                                 <i class="fas fa-eye-slash" style="position:absolute;right:3px;top:12px;visibility:visible;" @click="switchVisibility" ></i>
                    </b-input-group-btn>
                       
                       
                       </b-input-group>
                       
                  </b-form-group>  

                   

                     <b-form-group id="senha2" label="Redigite a senha" label-for="password2" class="required-field">
                       <b-form-input class="input" type="password" maxlength="10" name="email2" v-model="input.password2" placeholder="******* "/>
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
             passwordFieldType: 'password',
             
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
            this.fields.push({email:this.input.email,password:this.input.password});
         
            this.registerFile();
             
        },
        registerFile(){
            const data = JSON.stringify(this.fields);

            localStorage.setItem('fields',data);
            

            // alert(JSON.parse(localStorage.getItem('fields')));
          alert('Cadastrado com sucesso');

            
    
          
        },

        checkErrors(e){
              
             
            if(this.input.email && this.input.password && this.input.password === this.input.password2) {
                if(this.input.password.length < 5 && this.input.password2.length < 5){
                
                    this.input.errors.push('senha com no minímo 5 digitos')
                    e.preventDefault();
                    return false;
                  
            }else{
                this.register();
                return true;
                
            }
              
            }
          
            this.input.errors = [];    

           
            
            if(!this.input.email) 
                this.input.errors.push('O email é obrigatório');
            if(!this.input.password)
                 this.input.errors.push('a senha é obrigatório');
            if(!this.input.password2) 
                this.input.errors.push('por favor redigite a senha'); 
            if(this.input.password !== this.input.password2 || this.input.password > this.input.password2 || this.input.password2 > this.input.password)
                 this.input.errors.push('senhas não conferem');
          
            e.preventDefault();


           
           
         
           
            
            
        },
      

    }

        
    }


</script>


<style >
 

</style>

