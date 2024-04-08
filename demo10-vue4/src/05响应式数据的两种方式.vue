<script setup>
import {ref,reactive} from "vue"
/**
 * 让一个数据转化为响应式数据方法有两种
 *  ref函数 更适合单一变量 在script中要加value 在template中无需添加value
 *  reactive函数 更适合对象 在任何地方都直接使用对象名.属性名直接操作
 * 
 */
let count=ref(1)

let person=reactive({
  name:"tom",
  age:10
})

//toRef 将reactive中的某个属性转化为ref式的响应式数据
//toRefs 将reactive中的多个属性转化为ref式的响应式数据

</script>


<template>
  <div>
    <button @click="count++">+</button> <hr>
<button>{{ count }}</button> <hr>
<button @click="person.age++">+</button> <hr>
<button>{{person.name}}的年龄：{{ person.age }}</button> <hr>
  </div>
</template>

<style scoped>

</style>
