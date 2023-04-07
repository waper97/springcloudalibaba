import { createRouter, createWebHashHistory } from "vue-router";
import Login from '../views/login.vue'
import Hero from '../views/hero.vue'
import TheWelcome from '../views/TheWelcome.vue'

export const routes = [
    {
        path: '/',
        component:TheWelcome,
        hidden: true
    },
    {
        path: '/login',
        component:Login,
        hidden: true
    },
    {
        path: '/hero',
        // component: () => import ('@/views/hero.vue'),
        component: Hero,
        hidden: true
    },{
        path: '/item',
        component: () => import ('@/views/item.vue'),
        // hidden: true
    },
    {
        path: '/summoner',
        component: () => import ('@/views/summoner.vue'),
        // hidden: true
    },
    {
        path: '/error',
        component: () => import ('@/views/error.vue'),
        // hidden: true
    }
]
const router = createRouter({
    history: createWebHashHistory(),
    routes
})
export default router;
