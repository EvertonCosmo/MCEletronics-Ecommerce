
<template>
  <div>
    <main-bar></main-bar>
    <div>
      <b-container>
        <nav class="breadcrumb">
          <a href="/">Início</a>
          <span class="delimiter">
            <i class="fa fa-angle-right"></i>
          </span>
          <a href="#">Minha Conta</a>
        </nav>
      </b-container>

      <h2 class="text-center">Minha Conta</h2>
      <div class="text-center">
        <p>Olá {{user.username}}</p>
      </div>
      <b-card-group>
        <b-card style="max-width: 25rem" class="card">
          <b-list-group class="item">
            <b-list-group-item href="#">
              Painel
              <b-badge variant="primary" pill>14</b-badge>
              <i class="fas fa-tachometer-alt float-right card-list"></i>
            </b-list-group-item>
            <b-list-group-item href="#">
              Meu Perfil
              <i class="far fa-user float-right card-list"></i>
            </b-list-group-item>
            <b-list-group-item href="#">
              Pedidos
              <i class="fas fa-shopping-basket float-right card-list"></i>
            </b-list-group-item>
            <b-list-group-item href="#">
              Endereço
              <i class="fas fa-home float-right card-list"></i>
            </b-list-group-item>
            <b-list-group-item href="#">
              Detalhes da conta
              <i class="fas fa-info float-right card-list"></i>
            </b-list-group-item>
            <b-list-group-item style="cursor:pointer" @click="logout">
              Sair
              <i class="fas fa-sign-out-alt float-right card-list"></i>
            </b-list-group-item>

          </b-list-group>
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>

<script>
import MainBar from "../shared/MainBar.vue";
export default {
  name: "PageLogin",

  components: {
    MainBar
  },

  data() {
    return {
      user: {}
    };
  },

  created() {
    if (this.$session.exists()) {
      this.logged = true;
      this.user = JSON.parse(this.$session.get("user")); // get user from session, parse and convert in object from json
    } else {
      this.$router.push({ name: "login" });
    }
  },
  methods: {
    logout() {
      this.$session.destroy();
      this.logged = false;
      location.reload();
    }
  }
};
</script>

<style scoped>
.color {
  color: black;
}

#login {
  background-color: #ffffff;
  border: 1px solid #cccccc;
  padding: 20px;
  margin-top: 10px;
}
.card-list {
  margin-top: auto;
  margin-left: auto;
}
.card {
  border: none;
}
.item {
  width: 100%;
  padding: 5%;
  border-left: none;
  border-right: none;
}
.item > :hover {
  background-color: #033076;
  color: white;
}

span.delimiter {
  margin: 0 1.429em;
}

* {
  box-sizing: border-box;
}

.breadcrumb {
  background-color: transparent;
  margin-top: 1.786em;
  /* margin-left: 0%/ */
}
</style>


