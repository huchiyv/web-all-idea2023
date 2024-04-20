<script setup>
import axios from "axios"
import {ref,reactive} from 'vue'

let message=ref()

let data=reactive({
  code: 1,
  content: "我用尽了全部的运气，只为遇到你的那个瞬间，生命在那刻点亮。"
})

async function getMessage(){
  //使用axios发送请求获取message
  //axios({设置请求的参数}) 请求三要素 1url 2请求方式 3请求参数 keyvalue json。。。。
  let {data}=await getLoveMessage()
  message.value=data.content
  //Object.assign(message,data)


}

function getLoveMessage(){
  return axios.get("https://api.uomg.com/api/rand.qinghua?format=json")
}
</script>

<template>
  <div>
    <h1 >{{ message }}</h1>
    <hr>
    <button @click="getMessage">变</button>
  </div>
</template>

<style scoped>

</style>
