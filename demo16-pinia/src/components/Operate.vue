<script setup>
import {definePerson} from '../store/store.js'
let person=definePerson()
</script>

<template>
  <div>
<h1>operate</h1>
<input type="text" v-model="person.userName"> <br>
<input type="text" v-model="person.getAge">
<br>
<button @click="person.doubleAge()">年龄加倍</button> <br>
<button @click="person.$reset()">恢复默认</button>
  </div>
</template>

<style scoped>

</style>
