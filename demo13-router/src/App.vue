<script setup>
</script>

<template>
  <div>
    <router-link to="/home">home</router-link> <br>
    <router-link to="/list">list</router-link> <br>
    <router-link to="/add">add</router-link> <br>
    <router-link to="/update">update</router-link> <br>

    <hr>
      <router-view></router-view>
  </div>
</template>

<style scoped>

</style>
