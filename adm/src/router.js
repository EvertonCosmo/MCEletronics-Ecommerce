import Vue from 'vue';
import Router from 'vue-router';
import HomePageComponent from "./components/HomePage.vue"


Vue.use(Router)

export default new Router({
    mode:'history',
    routes: [
        
        {
            path: '*',
            component: HomePageComponent
        },
        {
            path:'/',
            component: HomePageComponent
        },
    ]

});
