<script setup>
import axios from "axios"
import {ref} from 'vue'

let message=ref()

function getMessage(){
  //使用axios发送请求获取message
  //axios({设置请求的参数}) 请求三要素 1url 2请求方式 3请求参数 keyvalue json。。。。
  let promise=axios({
    method:"get",
    url:"https://api.uomg.com/api/rand.qinghua?format=json",
    data:{

    }
  })

  promise.then(
    function(response){
      console.log(response.data)
      message.value=response.data.content
      /*
      response 响应结果对象
      data 服务响应会俩的数据
      status 响应状态码
      statusText 响应状态描述
      headers 本次响应的所有响应头
      config 本次亲求的配置信息
      request 本次请求发送时所使用的XMLHttpRequest对象
      
      */
    },
    function(){

    }
  )

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
