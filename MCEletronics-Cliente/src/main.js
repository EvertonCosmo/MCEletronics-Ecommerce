/*eslint no-console: "error"*/
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/'

import NProgress from 'nprogress'
import VueAwesomeSwiper from 'vue-awesome-swiper'


import VueSession from 'vue-session'

import BootstrapVue from 'bootstrap-vue'


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// require styles
import 'swiper/dist/css/swiper.css'


Vue.use(BootstrapVue)
Vue.use(VueSession)
Vue.use(VueAwesomeSwiper)


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