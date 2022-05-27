import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/pages/HelloWorld'
import UserInfo from "../pages/UserInfo";
import Login from "../pages/Login";
import Register from "../pages/Register"
import AllGame from "../pages/AllGame"
import singleGame from "../pages/singleGame"
import showGame from "../pages/showGame"
import admin from "../pages/admin"
import userHome from "../pages/userHome";
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [

    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/User',
      name: 'UserInfo',
      component: UserInfo
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path:'/register',
      name:'Register',
      component:Register
    },
    {
      path:'/allGame',
      name:'AllGame',
      component:AllGame
    },
    {
      path:'/singleGame',
      name:'singleGame',
      component:singleGame
    },
    {
      path:'/showGame',
      name:'showGame',
      component:showGame
    },
    {
      path:'/admin',
      name:'admin',
      component:admin
    },
    {
      path:'/userHome',
      name:'userHome',
      component:userHome
    }

  ]
})
