import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Login from '../views/Login.vue'
import Topic from '../views/Topic.vue'
import TopicList from '../views/TopicList.vue'
import Posting from '../views/Posting.vue'
import UserCenter from '../views/userCenter.vue'
import Register from '../views/register.vue'

Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/userCenter',
    name: 'UserCenter',
    component: UserCenter
  },
  {
    path: '/topic',
    name: 'Topic',
    component: Topic
  },
  {
    path: '/topicList',
    name: 'TopicList',
    component: TopicList
  },
  {
    path: '/posting',
    name: 'Posting',
    component: Posting
  },
  {
    path: '/main',
    name: 'Main',
    component: Main
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
