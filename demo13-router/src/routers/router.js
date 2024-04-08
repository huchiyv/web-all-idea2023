import{createRouter,createWebHashHistory} from 'vue-router'

import Home from '../components/Home.vue'
import List from '../components/List.vue'
import Add from '../components/Add.vue'
import Update from '../components/Update.vue'

let router=createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:'/',
            component:Home
        },
        {
            path:'/home',
            component:Home
        },
        {
            path:'/list',
            component:List
        },
        {
            path:'/add',
            component:Add
        },
        {
            path:'/update',
            component:Update
        }

    ]
})

export default router