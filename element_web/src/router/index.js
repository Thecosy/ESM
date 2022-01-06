import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index.vue"
import Update from "../views/Update";
import Add from "../views/Add";
Vue.use(VueRouter)

const routes = [
  {
    path: '/add',
    name: 'Add',
    component: Add
  },
  {
    path: '/update',
    name: 'Update',
    component: Update
  },
  {
    path: '/index',
    name: 'Index',
    component: Index
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
