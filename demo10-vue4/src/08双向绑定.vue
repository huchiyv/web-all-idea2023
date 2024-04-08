<script setup>
/**
 * 单项绑定 响应式数据发生变化时，更新dom树  用户操作的如果造成页面内容的改变不会影响响应式数据
 *          v-bind：
 * 双向绑定 页面上的数据由于用户的操作造成了改变，也会同步修改对应的响应式数据
 *          双向绑定一般用于表单标签
 *          双向绑定也有人称呼为收集表单信息的命令
 *          v-model:value="数据" 双向绑定
 *          v-model:value 一般神略：value
 */

import {reactive,ref} from "vue"
let user=reactive({
  username:"",
  age:""
})

let hbs=ref([])

</script>
<template>
  <div>
    <input type="text" v-model="user.username"> <br>
    <input type="password" v-model="user.userPwd"> <br>
    爱好：
    唱<input type="checkbox" v-model="hbs" value="sing">
    跳<input type="checkbox" v-model="hbs" value="dance">
    rap <input type="checkbox" v-model="hbs" value="rap">

    <hr>
    {{ user }}
    <hr>
    {{ hbs }}
  </div>
  
</template>

<style scoped>

</style>
