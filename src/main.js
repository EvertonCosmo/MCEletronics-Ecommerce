import Vue from 'vue'
import App from './App.vue'

import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


import VueRouter from 'vue-router'

import LoginComponent from './components/Login.vue'
import PageLoginComponent from "./components/PageLogin.vue";

Vue.use(BootstrapVue)
Vue.use(VueRouter)
Vue.config.productionTip = false
Vue.config.devtools = true


const routes =  [
  {
      path: "/",
      redirect: {
          name:"Login"
      }
  },
  {
      path:"/Login",
      name:"Login",
      component:LoginComponent
  },
  {
      path:"/PageLogin",
      name:"PageLogin",
      component:PageLoginComponent

  }

]
const router = new VueRouter({
  routes

});
new Vue({
  el:'#app',
  router,
  render: h => h(App),
}).$mount('#app')
