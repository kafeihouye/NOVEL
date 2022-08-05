import Vue from 'vue'
import App from './App'

// main.js
import uView from "uview-ui";
Vue.use(uView);
// 如此配置即可
uni.$u.config.unit = 'rpx'


Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()


