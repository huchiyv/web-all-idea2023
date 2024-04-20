<script setup>
import {definePerson} from '../store/store.js'
let person=definePerson()

</script>

<template>
  <div>
    <h1>list</h1>
    <button>{{ person.userName }}</button>
    {{ person }}
  </div>
</template>

<style scoped>

</style>
