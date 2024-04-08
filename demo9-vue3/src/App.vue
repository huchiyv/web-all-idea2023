<script type="module">
import {ref} from 'vue'
//ref处理的响应式数据，在script中 在操作时需要通过.value的形式操作
//在template中无需加.value
export default{
  setup(){
    let count=ref(1)
    function countIncr(){
        count.value++
    }
    function countDecr(){
        count.value--
    }
    function showCount(){
      alert(count.value)
    }
    return{
      count,
      countIncr,
      countDecr,
      showCount
    }
  }
}
</script>

<template>
  <div>
<button @click="countIncr">+</button>
<span v-text="count" ></span>
<button @click="countDecr">-</button>
<button @click="showCount">show</button>
  </div>

</template>

<style scoped>

</style>
