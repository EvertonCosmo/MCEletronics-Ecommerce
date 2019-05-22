import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import money from 'v-money'


import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



Vue.use(BootstrapVue)
Vue.config.productionTip = false
Vue.config.devtools = true
Vue.use(money, { precision: 4 })



new Vue({
  el:'#app',
  router,
  render: h => h(App),
}).$mount('#app')
