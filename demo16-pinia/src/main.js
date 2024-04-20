import { createApp } from 'vue'
import App from './App.vue'
import router from "./routers/router"
import {createPinia} from "pinia"

let pinia=createPinia()

let app =createApp(App)

app.use(router)
app.use(pinia)

app.mount('#app')
