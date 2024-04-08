<script setup>
//属性渲染 v-bind
let col="background-color:red"
</script>
<template>
  <div >

    <h1 v-bind:name="col">属性渲染v-bind</h1>
  </div>
</template>

<style scoped>

</style>
