/*eslint no-console: "error"*/
import Vue from 'vue'
import App from './App.vue'

import BootstrapVue from 'bootstrap-vue'


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


import VueRouter from 'vue-router'

// Components
import LoginComponent from '../src/components/LoginComponents/Login.vue'
import PageLoginComponent from '../src/components/LoginComponents/PageLogin.vue'
import RegisterComponent from '../src/components/LoginComponents/Register.vue'
import LogonBridgeComponent from '../src/components/LoginComponents/LogonBridge.vue'
import HomePageComponent from '../src/components/PageHome.vue'
import ProductViewComponent from '../src/components/ProductComponents/ProductView.vue'
import PageBagComponent from '../src/components/PageBag.vue'


Vue.use(BootstrapVue)
Vue.use(VueRouter)

Vue.config.productionTip = false
Vue.config.devtools = true




const routes = [{
        path: "*",
        component: HomePageComponent
    },
    {
        path: "/",
        component: HomePageComponent

    },
    {
        path: "/Login",
        name: "Login",
        component: LoginComponent
    },

    {
        path: "/PageLogin",
        name: "PageLogin",
        component: PageLoginComponent

    },
    {
        path: "/Register",
        name: "Register",
        component: RegisterComponent

    },
    {
        path: "/Bridge",
        name: "Bridge",
        component: LogonBridgeComponent
    },
    {
        path: "/PageHome",
        name: "PageHome",
        component: HomePageComponent
    },
    {
        path: "/Product",
        name: "Product",
        component: ProductViewComponent
    },
    {
        path: "/PageBag",
        name: "PageBag",
        component: PageBagComponent
    }

]

const router = new VueRouter({ routes });


new Vue({
    el: '#app',
    router,
    render: h => h(App),
}).$mount('#app')