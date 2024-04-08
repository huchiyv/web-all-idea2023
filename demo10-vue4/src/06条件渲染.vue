<script setup>
import {ref} from "vue"
let flag=ref(true)
/**
 * v-if="表达式/数据" 数据为true 则当前元素会渲染，否则不渲染
 * v-else 自动和前一个v-if做取反操作
 * 
 * v-show="" 数据为true 元素展示，否则不展示
 * 
 */

</script>
<template>
  <div>
    <h1 v-if="flag">hello vue</h1>
    <h1 v-else>haha vue</h1>
    <button @click="flag=!flag">按钮</button>

  </div>
</template>

<style scoped>

</style>
