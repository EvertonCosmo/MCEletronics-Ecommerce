<template> 
<div>

  <NavBar></NavBar>
  <!-- <router-view></router-view> -->
  <b-card tag="article" class ="mb-2" style="max-width: 25rem" title="Entrar" >
  
    <router-link :to="{name:'register'}">
        <b-button id="btn-cadastrar" class="float-right" style="background-color:#033076" >Cadastrar</b-button>
  </router-link>

  
                     
                        <b-button href="" block variant="danger"> <i class="fab fa-google"></i>  Login via Google</b-button>
                        <b-button href="" block variant="primary" style="background-color:#3b5998"> <i class="fab fa-facebook-f"></i>  Login via facebook</b-button>
                        <br> 
      <b-form @submit.prevent ="getUser" >
          <b-form-group id='email' label= "Email" label-for='email1' class="required-field">
              <!-- email -->
              <b-form-input v-model="user.email" class="input" name="email1"  id = "email" type="email"   placeholder="Digite seu email"/>
          </b-form-group>

          <b-form-group id='password'  label= 'Senha' label-for='nome1' class="required-field">
              <!-- name -->
              <b-form-input v-model="user.password" maxlength="10" class="input" name="password" id = "nome1" type="password"   placeholder="******"/>
          </b-form-group>


          <b-form-group id="checkbox">
              <b-form-checkbox-group  id="groupCheckBox">
                <b-form-checkbox value="Lembrar senha">Lembrar senha</b-form-checkbox>
                
              </b-form-checkbox-group>

          </b-form-group>
  

         <b-button id='btn-login' v-if="!loading" style= "background-color:#033076" type="submit"  block variant="primary">
           
           Login
           
           </b-button>

            <div v-else class="text-center">

                <b-spinner label="Loading..."  />

             </div>

         <div class="col-md-12 text-right">
              <a class="small" href="#">Esqueceu a Senha? </a>
          </div>     

      </b-form>

  </b-card>

  </div>

  
</template>

<script>
/* eslint-disable */
import NavBar from '../BarComponents/NavBar.vue'
import api from "../../services/api.js"
import { setTimeout } from 'timers';


export default {
  name:'Login', 
  
  data(){
    return {
        
      loading:false,
      user:{
        email:"",
        password:""
      },
      user1:{
        
      }
    }
  },
  
  methods:{ 

    sleep(milliseconds) {
      var start = new Date().getTime();
      for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds){
          break;
        }
      }
    },
    getUser(e){
        api.getUser(this.user.email).then(Response =>{
          this.user1 = Response.data
          this.login(e)
      }).catch(e => {
        console.log(e)
      })
    },

    login(e){ /* checks data equality with data in localstorage  */ 
     
      if(this.user.email != "" && this.user.password != "") {
        
          if(this.user.email == this.user1.email && this.user.password == this.user1.password){
              
               this.loading = true;  // spinner valueinputinputinputinput
                  
               setTimeout(this.placeLogin,1200); // wait 1,5 second tinputo call new Routeinpuinputinputinputt
                
          }else{
            alert("email ou senha incorretos")
            e.preventDefault();
            
          }
        }else{
          alert("necessário email e senha")
          e.preventDefault()
        }
      
  },

    placeLogin(){
            // replace router(page) to PageLogin
           this.$router.push({path:'/'})
           
      },
  },
    components:{
      NavBar
    }
}


</script>

<style >

.required-field > label::after {
  content: '*';
  color: black;
  margin-left: 0.25rem;
}
  .input{
    width:100%;
    margin:auto;
  }
  .mb-2{
    margin: 0 auto;
    float: none;
    margin-top: 2%; 
    border:1px solid #c0c0c0;
    
  }
/* #btn-login{
    margin-left: 0px;
    max-width: 10rem;
    width: 50%;
} */
#btn-cadastrar {
  /* margin-bottom: 10px; */
  margin:0 0  10px;

  
}

  
</style>


