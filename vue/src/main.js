// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Axios from 'axios'
import axios from 'axios'
// import 'bootstrap3/dist/css/bootstrap.min.css'
// import 'bootstrap3/dist/js/bootstrap.min'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import qs from 'qs';
Vue.prototype.$qs = qs
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import cookies from 'vue-cookies'
Vue.prototype.$cookies = cookies;
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

import VueAxios from 'vue-axios'
Vue.use(VueAxios,axios);
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.$axios=Axios
Axios.defaults.baseURL='/api'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
