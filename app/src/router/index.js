import Vue from 'vue'
import VueRouter from 'vue-router'
import Inicio from '../views/Inicio.vue'
import CadastrarProposta from '../views/proposta/CadastrarProposta'
import ListarPropostas from '../views/proposta/ListarPropostas'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Inicio',
        component: Inicio
    },
    {
        path: '/cadastrar-proposta/',
        name: 'cadastrarProposta',
        component: CadastrarProposta

    },
    {
        path: '/cadastrar-proposta/:proposta',
        name: 'cadastrarPropostaParametros',
        component: CadastrarProposta,
        props: true
    },
    {
        path: '/listar-propostas',
        name: 'listarPropostas',
        component: ListarPropostas
    },
]

const router = new VueRouter({
    routes
})

export default router
