<script setup>
/*
v-on:事件名称="函数名（）"
v-on：事件名可以简写@事件名
原生js事件都是on+事件名 ：onclick
vue里面没有on ：click

*/
import{ref} from "vue"
let count=ref(1);
</script>

<template>
  <div>
<!-- 内联事件处理 -->
<button @click="count++">+</button> <hr>
<h1>{{ count }}</h1> <hr>
<!-- 事件修饰符  .once只执行一次，.prevent阻止组件默认行为-->
<button @click.once="count--">-</button>

  </div>
</template>

<style scoped>

</style>
