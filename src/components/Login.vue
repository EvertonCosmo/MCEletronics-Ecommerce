<template> 
<div>

  <NavBar></NavBar>
  <!-- <router-view></router-view> -->
  <b-card tag="article" class ="mb-2" style="max-width: 25rem" title="Entrar" >
  
    <router-link to="/Register" >
        <b-button id="btn-cadastrar" class="float-right" style="background-color:#033076" >Cadastrar</b-button>
  </router-link>

  <router-view ></router-view>
                     
                        <b-button href="" block variant="danger"> <i class="fab fa-google"></i>  Login via Google</b-button>
                        <b-button href="" block variant="primary" style="background-color:#3b5998"> <i class="fab fa-facebook-f"></i>  Login via facebook</b-button>
                        <br> 
      <b-form >
          <b-form-group id='email' label= "Email" label-for='email1' class="required-field" @click ="login">
              <!-- email -->
              <b-form-input v-model="input.email" class="input" name="email1"  id = "email" type="email"   placeholder="digite seu email"/>
          </b-form-group>

          <b-form-group id='password'  label= 'Senha  ' label-for='nome1' class="required-field">
              <!-- name -->
              <b-form-input v-model="input.password" maxlength="10" class="input" name="password" id = "nome1" type="password"   placeholder="******"/>
          </b-form-group>


          <b-form-group id="checkbox">
              <b-form-checkbox-group  id="groupCheckBox">
                <b-form-checkbox value="Lembrar senha">Lembrar senha</b-form-checkbox>
                
              </b-form-checkbox-group>

          </b-form-group>
  

         <b-button id='btn-login' v-if="!loading" style= "background-color:#033076" type="submit"  @click ="login" block variant="primary">
           
           Login
           
           </b-button>

            <div v-else class="text-center">

                <b-spinner label="Loading..."  />

             </div>

         <div class="col-md-12 text-right">
              <a class="small" href="#">Esqueceu a Senha ? </a>
          </div>     
      </b-form>

  </b-card>

  </div>

  
</template>

<script>
import NavBar from './NavBar'
import { setTimeout } from 'timers';

export default {
  name:'Login', 
  
  data(){
    return {
        
      loading:false,
      fields: JSON.parse(window.localStorage.getItem('fields')), // get data from localstorage browser
      input:{
        email:"",
        password:""
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
    
      login(e){ /* checks data equality with data in localstorage  */
     
                 
        if(this.input.email != "" && this.input.password != "") {
          if(this.input.email == this.fields[0].email && this.input.password == this.fields[0].password){
              
                this.$emit('authenticated',true);  //emit event of authenticated > received by App.vue
          
                 this.loading = true;  // spinner value
                  
                  setTimeout(this.placeLogin,1500); // wait 1,5 second to call new Route
                
          }else{
            alert("email ou senha incorretos")
            e.preventDefault();
            
          }
        }else{
          alert("necessário email e senha")
          e.preventDefault();
        }
        
      },
      placeLogin(){
            // replace router(page) to PageLogin
           this.$router.push({name:'PageLogin'})
           
      },
      placeHome(){
        this.$router.push({path:'/'})
      }
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


