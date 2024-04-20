<script setup>
import {definePerson} from './store/store'
let person=definePerson()
</script>

<template>
  <div>
    <router-view name="operateView"></router-view>
    <hr>
    <router-view name="listView"></router-view>
  </div>
</template>

<style scoped>

</style>
