<template> 
<div>

  <NavBar></NavBar>

  <b-card tag="article" class ="mb-2" style="max-width: 25rem" title="Entrar" >
    <router-link to="/Register">
        <b-button id="btn-cadastrar" class="float-right"  href="" variant="outline-primary">Cadastrar</b-button>
  </router-link>

  <router-view ></router-view>
                     
                        <b-button href="" block variant="outline-danger"> <i class="fab fa-google"></i>  Login via Google</b-button>
                        <b-button href="" block variant="outline-primary"> <i class="fab fa-facebook-f"></i>  Login via facebook</b-button>
                        <br> 
      <b-form >
          <b-form-group id='email' label= "Email" label-for='email1' class="required-field">
              <!-- email -->
              <b-form-input v-model="input.email" class="input" name="email1"  id = "email" type="email"   placeholder="digite seu email"/>
          </b-form-group>

          <b-form-group id='password'  label= 'Senha  ' label-for='nome1' class="required-field">
              <!-- name -->
              <b-form-input v-model="input.password" class="input" name="password" id = "nome1" type="password"   placeholder="******"/>
          </b-form-group>


          <b-form-group id="checkbox">
              <b-form-checkbox-group  id="groupCheckBox">
                <b-form-checkbox value="Lembrar senha">Lembrar senha</b-form-checkbox>
                
              </b-form-checkbox-group>

          </b-form-group>

         <b-button id='btn-login' style= "background-color:#033076" type="submit"  @click ="login()" block variant="primary">Login</b-button>
        
         <div class="col-md-12 text-right">
              <a class="small" href="#">Esqueceu a Senha ? </a>
          </div>     
      </b-form>
  </b-card>
  </div>
</template>

<script>
import NavBar from './NavBar'

export default {
    name:'Login', 

    data(){
      return {
        input:{
            email:"",
            password:""
        }

      }
    } ,

    methods:{ 
      login(){ /* checks data equality with data in parent component */
        if(this.input.email != "" && this.input.password != "") {
          if(this.input.email == this.$parent.mockAccount.email && this.input.password == this.$parent.mockAccount.password){
                this.$emit('authenticated',true);  //emit event of authenticated > received by App.vue
                this.$router.replace({name:'PageLogin'}) // replace router(page) to PageLogin
                
          }else{
            alert("nome ou senha incorretos")
          }
        }else{
          alert("necessário email e senha")
        }
      }
    },
    components:{
      NavBar
    }
}

</script>

<style>
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
  margin:0 0 10px;
  
}

  
</style>



