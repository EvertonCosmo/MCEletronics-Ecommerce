<template> 
<div>
  <NavBar></NavBar>
  <b-card tag="article" class ="mb-2" style="max-width: 25rem" title="Sign in" >
  
    <b-button id="btn-cadastrar" class="float-right"  href="#" variant="outline-primary">Cadastrar</b-button>
                     
                        <b-button href="" block variant="outline-info"> <i class="fab fa-google"></i>   Login via Google</b-button>
                        <b-button href="" block variant="outline-primary"> <i class="fab fa-facebook-f"></i>   Login via facebook</b-button>
                      <br> 
      <b-form >
          <b-form-group id='email' label= "Email:" label-for='email1'>
              <!-- email -->
              <b-form-input class="input" id = "email" type="email"  required placeholder="digite seu email"/>
          </b-form-group>

          <b-form-group id='password' label= 'Senha:' label-for='nome1'>
              <!-- name -->
              <b-form-input class="input" id = "nome1" type="password"  required placeholder="******"/>
          </b-form-group>


          <b-form-group id="checkbox">
              <b-form-checkbox-group  id="groupCheckBox">
                <b-form-checkbox value="Lembrar senha">Lembrar senha</b-form-checkbox>
                
              </b-form-checkbox-group>

          </b-form-group>

         <b-button id='btn-login' style= "background-color:#033076" type="submit"  block variant="primary">Login</b-button>
        
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
    components:{
      NavBar
    }
}

</script>

<style scoped>
  .input{
    width:90%;
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
  margin-bottom: 10px;
}

  
</style>



