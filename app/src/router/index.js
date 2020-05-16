import Vue from 'vue'
import VueRouter from 'vue-router'
import Inicio from '../views/Inicio.vue'
import CadastrarProposta from '../views/cadastrar-proposta/CadastrarProposta'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Inicio',
        component: Inicio
    },
    {
        path: '/cadastrar-proposta',
        name: 'cadastrarProposta',
        component: CadastrarProposta
    },
]

const router = new VueRouter({
    routes
})

export default router
