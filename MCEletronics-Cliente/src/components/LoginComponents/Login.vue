<template>
  <div>
    <NavBar></NavBar>

    <b-card tag="article" class="mb-2" style="max-width: 35rem; border:solid 1px rgba(0,0,0,0.1)" title="Entrar">
      <router-link :to="{name:'register'}">
        <b-button id="btn-cadastrar" class="float-right" style="background-color:#033076">Cadastrar</b-button>
      </router-link>

      <b-button href block variant="danger">
        <i class="fab fa-google"></i> Login via Google
      </b-button>
      <b-button href block variant="primary" style="background-color:#3b5998">
        <i class="fab fa-facebook-f"></i> Login via facebook
      </b-button>
      <br>
      <b-form @submit.prevent="login">
        <div
          class="alert alert-danger"
          role="alert"
          v-for="(error, index) in errorMessage"
          :key="index"
        >{{error}}</div>

        <b-form-group
          id="username"
          label="Nome de Usuário"
          label-for="usrname"
          class="required-field"
        >
          <b-form-input
            v-model="user.username"
            class="input"
            name="username"
            id="username"
            type="text"
            placeholder="Nome de Usuário"
          />
        </b-form-group>

        <b-form-group id="password" label="Senha" label-for="nome1" class="required-field">
          <b-form-input
            v-model="user.password"
            maxlength="10"
            class="input"
            name="password"
            id="nome1"
            type="password"
            placeholder="******"
          />
        </b-form-group>

        <b-form-group id="checkbox">
          <b-form-checkbox-group id="groupCheckBox">
            <b-form-checkbox value="Lembrar senha">Lembrar senha</b-form-checkbox>
          </b-form-checkbox-group>
        </b-form-group>

        <b-button
          id="btn-login"
          v-if="!loading"
          style="background-color:#033076"
          type="submit"
          block
          variant="primary"
        >Login</b-button>

        <div v-else class="text-center">
          <b-spinner label="Loading..."/>
        </div>

        <div class="col-md-12 text-right">
          <a class="small" href="#">Esqueceu a Senha?</a>
        </div>
      </b-form>
    </b-card>
  </div>
</template>

<script>
/* eslint-disable */
import NavBar from "./../shared/LoginBar";
import api from "../../services/api.js";
import { mapState, mapActions, mapMutations } from "vuex";
import { errorToaster } from "../../services/ErrorHandler";
import { setTimeout } from "timers";

export default {
  name: "Login",

  data() {
    return {
      loading: false,
      user: {
        username: "",
        password: ""
      },
      isSignUp: false,
      errorMessage: []
    };
  },

  methods: {
    

    login(event) {
      if (this.user.username == "" && this.user.password == "") {
        this.errorMessage.push("Necessário nome de usuário e senha");
      }

      const user = {
        username: this.user.username,
        password: this.user.password
      };
      api.postLogin(user).then(Response => {
          if (Response.status == 200) {
            this.loading = true;

            this.$session.start(); // start session 

            this.$session.set("user", 
              JSON.stringify({
                username: this.user.username,
                password: this.user.password
              })
            ); // set user from session(JSON)

            setTimeout(this.placeLogin, 1200); // wait 1.2 sec and go login page

          }

          if (Response.status == 401) {
            errorToaster("Usuário já registrado ");
          }

        })
        .catch(e => {
          console.log(e);
          errorToaster("Não foi possivel realizar login");
        });
    },

    placeLogin() {
      this.$router.push({ path: "/" });
    }
  },
  components: {
    NavBar
  }
};
</script>

<style >
.required-field > label::after {
  content: "*";
  color: black;
  margin-left: 0.25rem;
}
.input {
  width: 100%;
  margin: auto;
}
.mb-2 {
  margin: 0 auto;
  float: none;
  margin-top: 2%;
  border: 1px solid #c0c0c0;
}

#btn-cadastrar {
  /* margin-bottom: 10px; */
  margin: 0 0 10px;
}
</style>


