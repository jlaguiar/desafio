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
    }
  },
  modules: {
  }
})
