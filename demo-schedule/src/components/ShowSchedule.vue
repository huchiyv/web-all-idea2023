<script setup>
import { defineSchedule } from '../store/scheduleStore';
import { defineUser } from '../store/userStore';
/* 引入挂载生命周期 */
import { onMounted,onUpdated,ref,reactive } from 'vue';
import request from "../utils/request"

let sysUser=defineUser()
let schedule=defineSchedule()
    
    // 第一次挂载就立刻向后端发送请求,获取最新数据
    onMounted(async function (){
        showSchedule()
    })
    async function showSchedule(){
        let {data} = await request.get("/schedule/findAllSchedule",{params:{"uid":sysUser.uid}})
        console.log(data)
        schedule.itemList =data.data.itemList
    }

    async function addItem(){
       let {data}=await request.get("/schedule/addDefaultSchedule",{params:{"uid":sysUser.uid}})
        if(data.code==200){
            //增加成功，刷新页面数据
            showSchedule()
        }else{
            alert("添加失败")
        }
    }

   async function update(index){
        //找到要修改的数据
        let{data}= await request.post("/schedule/updateSchedule",schedule.itemList[index])   
        if(data.code==200){
            showSchedule()
            alert("更新成功")
        }else{
            alert("更新失败")
        }
    }

    async function removeItem(index){
        let sid=schedule.itemList[index].sid
        let {data} =await request.get("/schedule/removeSchedule",{params:{"sid":sid}})

        if(200==data.code){
            showSchedule()
            alert("更新成功")
        }else{
            alert("更新失败")
        }

    }

</script>

<template>
  <div>
    <h3 class="ht">您的日程如下</h3>
<table class="tab" cellspacing="0px">
    <tr class="ltr">
        <th>编号</th>
        <th>内容</th>
        <th>进度</th>
        <th>操作</th>
    </tr>
    <tr class="ltr" v-for="item,index in schedule.itemList" :key="index">
        <td>{{ index+1 }}</td>
        <td>
            <input type="text" v-model="item.title">
        </td>
        <td>
            <input type="radio" v-model="item.completed" value="1">已完成
            <input type="radio" v-model="item.completed" value="0">未完成
        </td>
        <td class="buttonContainer">
             <button class="btn1" @click="removeItem(index)">删除</button>
            <button class="btn1" @click="update(index)">保存修改</button>
        </td>
    </tr>
    <tr class="ltr buttonContainer" >
        <td colspan="4">
            <button class="btn1" @click="addItem">新增日程</button>
        </td>

    </tr>
</table>
  </div>
</template>

<style scoped>

      .ht{
            text-align: center;
            color: cadetblue;
            font-family: 幼圆;
        }
        .tab{
            width: 80%;
            border: 5px solid cadetblue;
            margin: 0px auto;
            border-radius: 5px;
            font-family: 幼圆;
        }
        .ltr td{
            border: 1px solid  powderblue;

        }
        .ipt{
            border: 0px;
            width: 50%;

        }
        .btn1{
            border: 2px solid powderblue;
            border-radius: 4px;
            width:100px;
            background-color: antiquewhite;

        }
        #usernameMsg , #userPwdMsg {
            color: gold;
        }

        .buttonContainer{
            text-align: center;
        }

</style>
