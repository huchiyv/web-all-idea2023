/*
存储日程信息
*/
import {defineStore} from 'pinia'
export const defineSchedule=defineStore(
    "scheduleList",
    {
        state:()=>{
            return{
                itemList:[]
            }
        },
        getters:{
    
        },
        actions:{
            
        }
        
    }
)