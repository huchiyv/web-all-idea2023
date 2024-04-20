import {defineStore} from "pinia"

export const definePerson=defineStore({
    id:'personPinia',//全局唯一id
    state:()=>{//响应式数据，固定写法
        return{
            userName:"xiaoming",
            age:24,
            hobbies:["sing","rap"]
        }
    },
    getters:{//定义计算查看数据的方法
        getAge(){
            return this.age
        },
        getHobbiesCount(){
            return this.hobbies.length
        }
    },
    actions:{//定义修改数据的方法
        doubleAge(){
            this.age*=2
        }
    }


})