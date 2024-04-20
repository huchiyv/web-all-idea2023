import {createRouter,createWebHashHistory} from "vue-router"

import Login from "../components/Login.vue"
import Header from "../components/Header.vue"
import Regist from "../components/Regist.vue"
import ShowSchedule from "../components/ShowSchedule.vue"

import { defineUser } from "../store/userStore"
import pinia from "../pinia.js"

let sysUser=defineUser(pinia)

const router=createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:"/",
            redirect:"/showSchedule"
        },
        {
            path:"/login",
            component:Login
        },
        {
            path:"/regist",
            component:Regist
        },
        {
            path:"/showSchedule",
            component:ShowSchedule
        },
 
        {
            path:"/header",
            component:Header
        }

    ]
})
//路由得全局前置守卫
router.beforeEach((to,form,next)=>{
    if(to.path=='/showSchedule'){
        if(sysUser.username==''){
            next('/login')
        }else{
            next()
        }

    }else{
        next()
    }
})


export default router