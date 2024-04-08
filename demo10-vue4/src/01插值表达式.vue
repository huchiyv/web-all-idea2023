<script setup>
/*
插值表达式 语法{{数据名字/函数/对象调用API}}
*/
let msg="hello vue3"
let getMsg=()=>"hello vue3 message"
let age=19
let bee="蜜 蜂"
let carts=[
  {name:"可乐",price:100,num:10},{name:"炸鸡",price:1,num:10}
]
function compute(){
  let count=0
  for(let index in carts){
    count+=carts[index].num*carts[index].price
  }
  return count
}
</script>

<template>
  <div>
    <!-- 将数据绑定到下列元素上 -->
    <h1>{{ msg }}</h1> <hr>
    msg的值为{{msg}} <hr>
    msg的值为{{ getMsg() }} <hr>
    <!-- 插值表达式的常见运算 -->
    年龄：{{ age }},是否成年：{{ age>18?'是': '否'}} <hr>

    <!-- 调用API -->
    {{ bee.split('').reverse().join('') }} <hr>
    {{ compute() }}
  </div>
</template>

<style scoped>

</style>
