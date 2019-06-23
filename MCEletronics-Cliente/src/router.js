import Vue from 'vue'
import Router from 'vue-router'


import LoginComponent from './components/LoginComponents/Login.vue'
import RegisterComponent from './components/LoginComponents/Register.vue'
import PageHomeComponent from './components/PageHome.vue'
import ProductViewComponent from './components/ProductComponents/ProductView.vue'
import BagComponent from '../src/components/PageBag.vue'
import DashBoardComponent from './components/LoginComponents/PageLogin.vue'
import AllProductsComponent from './components/ProductComponents/AllProducts.vue'

Vue.use(Router)

export default new Router({
    mode:'history',
    routes: [
        {
            path:'*',
            component:PageHomeComponent
        },
        {
            path:'/',
            component:PageHomeComponent
        },
        {
            path:'/login',
            name:'login',
            component:LoginComponent
            
        },
        {
            path:'/register',
            name:'register',
            component:RegisterComponent
        },
        {
            path:'/product-view/:name',
            name:'product-view',
            component:ProductViewComponent,
            props:true
        },
        {
            path:'/bag',
            name:'bag',
            component:BagComponent
        },
        {
            path:'/dashboard',
            name:'dashboard',
            component:DashBoardComponent,
            props:true
        },
        {
            path:'./allproducts',
            name:'all-products',
            component:AllProductsComponent,
            props:true
        }
    ]
   

});