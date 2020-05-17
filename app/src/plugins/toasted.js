import Vue from 'vue'
import Toasted from 'vue-toasted'

Vue.use(Toasted, {
    theme: "toasted-primary",
    duration: 3000
})

Vue.toasted.register(
    'defaultSuccess',
    'Operação realizada com sucesso',
    {type: "success", icon: 'check'}
)

Vue.toasted.register(
    'defaultError',
    payload => !payload.msg ? 'Ocorreu um erro' : payload.msg,
    {type: "error", icon: 'close'}
)