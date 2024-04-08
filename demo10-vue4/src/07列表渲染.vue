<script setup>
import {reactive} from "vue"
let items  = reactive([
{name:"可乐",price:1,num:10},
{name:"炸鸡",price:1,num:10},
{name:"薯片",price:1,num:10}
])

let carts=reactive([
{id:1,name:"可乐",price:3,num:10},
{id:2,name:"炸鸡",price:20,num:1},
{id:3,name:"薯片",price:5,num:6}
])

function getTotalPrice(){
  let total=0
  for(let index in carts){
    total+=carts[index].price*carts[index].num
  }
  return total
}

function removeCart(index){
  carts.splice(index,1)
}

function clearCart(){
  //调用API清空
  carts.splice(0,carts.length)
}

</script>

<template>
  <div>
    <h1>购物清单</h1>
    <hr>
<table>
  <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>价格</th>
      <th>数量</th>
      <th>小计</th>
      <th>操作</th>
    </tr>
  </thead>
  <!-- 当购物车中有购物项时候展示这个tbody -->
  <tbody v-if="carts.length>0">
    <tr v-for="(produce,index) in carts" :key="produce.id" >
      <td>{{ index+1 }}</td>
      <td>{{ produce.name }}</td>
      <td>{{ produce.price }}</td>
      <td>{{ produce.num }}</td>
      <td>{{ produce.num*produce.price }}</td>
      <td>
        <button @click="produce.num++">+</button>
        <button @click="produce.num--">-</button>
        <button @click="removeCart(index)">全部删除</button>
      </td>
    </tr>
    <tr>总计：{{ getTotalPrice() }}</tr>
  </tbody>
  <!-- 没有购物项时展示这个 -->
  <tbody v-else>
    <tr>
      <td colspan="6">您的购物车空空如也</td>
    </tr>
  </tbody>
</table>
<button @click="clearCart()">一键清空</button>
    <hr>

    <ul>
      <li v-for="(item,index) in items" v-bind:key="item.name">
        {{ index+1 }}{{ item.name }}
      
      </li>
    </ul>
  </div>
</template>

<style scoped>

</style>
