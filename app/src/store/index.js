import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const api = axios.create({
  baseURL: 'http://localhost:8080/'
});

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
    async buscarPropostas(context){
      const {data} = await api.get('propostas')
      return data
    },
    async bucarPropostasNotas(context){
      const {data} = await api.get('propostas/notas')
      return data
    },
    async bucarPropostasPrecos(context){
      const {data} = await api.get('propostas/precos')
      return data
    },
    async excluir(context,id){
      await api.delete(`proposta/${id}`)
      return
    },
    async salvar(context, proposta){
      await api.post('proposta', proposta)
    },
    async editar(context, proposta){
      await api.put('proposta', proposta)
    }
  },
  modules: {
  }
})
