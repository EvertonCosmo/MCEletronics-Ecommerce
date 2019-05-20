/*eslint no-console: "error"*/
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/'

import NProgress from 'nprogress'
 

import VueSession from 'vue-session'
Vue.use(VueSession)
import BootstrapVue from 'bootstrap-vue'
// import VueCarousel from '@chenfengyuan/vue-carousel';

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


Vue.use(BootstrapVue)

// Vue.use(VueCarousel);

Vue.config.productionTip = false
Vue.config.devtools = true

router.beforeResolve((to, from, next) => {
    if (to.name) {
        NProgress.start()
    }
    next()
})
router.afterEach(() => {
    NProgress.done()
})

new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App),
}).$mount('#app')