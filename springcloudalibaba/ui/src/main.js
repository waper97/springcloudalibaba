import { createApp } from 'vue'

import App from './App.vue'
import Router from './router/index.js'
import VueAxios from "vue-axios";

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/dark/css-vars.css'
import axios from 'axios'
const app = createApp(App);
app.use(Router)
app.use(ElementPlus)
app.use(VueAxios,axios)
app.mount(`#app`)
app.config.globalProperties.$axios = axios