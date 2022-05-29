// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Axios from 'axios'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import qs from 'qs';
Vue.prototype.$qs = qs
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vuetify from 'vuetify'
import vuetify from '@/plugins/vuetify'

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
import header from "./pages/header";
Vue.component('headbar', header);
import userTable from "./pages/userTable";
Vue.component('userTable',userTable);
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import updatePass from "./pages/updatePass";
Vue.component('updatePass', updatePass);
import gameCheck from "./pages/gameCheck";
Vue.component('gameCheck',gameCheck);

/* eslint-disable no-new */
new Vue({
  vuetify,
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
