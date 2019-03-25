/* eslint-disable */ 
// eslint-disable-next-line 

import Vue from 'vue'
import App from './App.vue'

import BootstrapVue from 'bootstrap-vue'


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


import VueRouter from 'vue-router'

// Components
import LoginComponent from './components/Login.vue'
import PageLoginComponent from './components/PageLogin.vue';
import RegisterComponent from './components/Register.vue'
import LogonBridgeComponent from './components/LogonBridge.vue'




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

  },
  {
    path:"/Register",
    name:"Register",
    component:RegisterComponent
    
  },
  {
    path:"/Bridge",
    name:"Bridge",
    component:LogonBridgeComponent
  }
  

]

const router = new VueRouter({routes});


new Vue({
  el:'#app',
  router,
  render: h => h(App),
}).$mount('#app')
