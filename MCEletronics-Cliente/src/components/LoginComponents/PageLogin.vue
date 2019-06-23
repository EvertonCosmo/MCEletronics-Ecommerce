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
          <a href="/dashboard">Minha Conta</a>
        </nav>
      </b-container>

      <h2 class="text-center">Minha Conta</h2>
      <div class="text-center">
        <p>Olá {{user.username}}</p>
      </div>
    <hr>
      <div class="row" style="width:100%; padding:2%">
        <div class="col-sm-3">
        <b-card-group>
          <b-card style="max-width: 25rem" class="card">
            <b-list-group class="item">
              <b-list-group-item @click="showPanel" style="cursor:pointer" >
                Painel
                <b-badge variant="primary" pill>14</b-badge>
                <i class="fas fa-tachometer-alt float-right card-list"></i>
              </b-list-group-item >
              <!-- <b-list-group-item style="cursor:pointer">
                Meu Perfil
                <i class="far fa-user float-right card-list"></i>
              </b-list-group-item > -->
              <b-list-group-item @click="showOrdered" style="cursor:pointer">
                Pedidos
                <i class="fas fa-shopping-basket float-right card-list"></i>
              </b-list-group-item>
              <b-list-group-item style="cursor:pointer">
                Endereços
                <i class="fas fa-home float-right card-list"></i>
              </b-list-group-item>
              <b-list-group-item @click="showAccountDetails" style="cursor:pointer">
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
        <aside class="col-sm-8" style="margin-top:2%">
            <account-details v-show="accountview" :user="user" style="margin-left:5%" /> 
            <panel v-show="panelview" />
            <Order v-show="orderView"/>
        </aside>

      </div>
   
  </div>
  <PageFooter></PageFooter>
  </div>
</template>

<script>
import MainBar from "../shared/MainBar.vue";
import AccountDetails from '../DashboardComponents/AccountDetails'
import Panel from '../DashboardComponents/Panel'
import PageFooter from "../PageFooter"
import Order from '../DashboardComponents/Order'
export default {
  name: "PageLogin",

  components: {
    MainBar,AccountDetails,PageFooter,Panel,Order
  },

  data() {
    return {
      user: {},
      accountview : false,
      panelview : false,
      orderView: false
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
    },
    showAccountDetails() {
      this.accountview = true
      this.panelview = false
      this.orderView = false
    },
    showOrdered() {
      this.orderView = true,
      this.accountview = false,
      this.panelview = false
    },
    showPanel(){
      this.panelview = true
      this.accountview = false
      this.orderView = false 
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


