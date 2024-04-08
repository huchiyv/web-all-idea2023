<script setup>
/*引入多个.vue组件 */
import Header from "./components/Header.vue"
import Navigator from "./components/Navigator.vue";
import Content from "./components/Content.vue";
import {ref} from 'vue'
let menu=ref('')
function receiver(data){
  menu.value=data
}

</script>

<template>
  <div>
    <Header class="Header"></Header>
    <Navigator @sendMenu="receiver" class="Navigator"></Navigator>
    <Content class="Content" :message="menu"></Content>
  </div>
</template>

<style scoped>

.Header{
  height: 80px;
  border:1px solid red;
}

.Navigator{
  width: 15%;
  height: 800px;
  border:1px solid green;
  float: left;
}

.Content{
  width: 84%;
  height: 800px;
  border:1px solid blue;
  float: right;
}

</style>
