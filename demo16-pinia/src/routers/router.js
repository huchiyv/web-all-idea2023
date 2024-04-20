import{createRouter,createWebHashHistory} from 'vue-router'

import List from '../components/List.vue'
import Operate from '../components/Operate.vue'

const router=createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:"/list",
            components:{
                listView:List
            }

        },
        {
            path:"/operate",
            components:{
                operateView:Operate
            }
        },
        {
            path:"/",
            components:{
                listView:List,
                operateView:Operate
            }
        },
        
    ]
})

export default router