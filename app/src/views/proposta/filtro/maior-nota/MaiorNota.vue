<template>
    <div>
        <tabela-filtro :lista-propostas="listaPropostas"
                        :propostas-label="propostasLabel"
                       label="Classificação maior nota"
                       @verMais="verMais"/>
        <barra-carregamento :dialog="dialogCarregar"
                            label="Carregando"/>
    </div>

</template>

<script>
    import {mapActions} from 'vuex'
    import BarraCarregamento from '../../../../components/BarraCarregamento'
    import TabelaFiltro from '../commons/TabelaFiltro'

    export default {
        name: 'MaiorNota',
        components: {TabelaFiltro,BarraCarregamento},
        data: () => ({
            dialogCarregar: false,
            propostasLabel: [
                {text: 'Forncedor', value: 'fornecedor', sortable: false},
                {text: 'Nota', value: 'nota', sortable: false},
                {text: 'Preço (R$)', value: 'preco', sortable: false},
                {text: 'Data', value: 'dataCadastro', sortable: false},
                {text: 'Ações', value: 'actions', sortable: false},
            ],
            listaPropostas: [],
            listaPropostasNota: []
        }),
        async mounted() {
            await this.preencherLista()
        },
        methods: {
            ...mapActions(['bucarPropostasNotas']),
            async ordenarListaNotaMaior() {
                await this.listaPropostasNota.sort(function (valor1, valor2) {
                    if (valor1.nota > valor2.nota) {
                        return -1
                    } else if (valor1.nota < valor2.nota) {
                        return 1
                    } else {
                        if (valor1.preco < valor2.preco) {
                            return -1
                        } else if (valor1.preco > valor2.preco) {
                            return 1
                        } else {
                            debugger
                            if (valor1.dataCadastroInteiro < valor2.dataCadastroInteiro) {
                                return -1
                            } else if (valor1.dataCadastroInteiro > valor2.dataCadastroInteiro) {
                                return 1
                            } else {
                                return 0
                            }
                        }
                    }
                })
                return this.listaPropostasNota
            },
            parseDataParaInteiro() {
                this.listaPropostasNota.forEach(function (element, index) {
                    let projetoModificado = this[index].dataCadastro.replace(/\D/g, ' ')
                    projetoModificado = projetoModificado.split(' ')
                    let projetoJuncao = projetoModificado[2]
                    projetoJuncao = projetoJuncao + projetoModificado[1] + projetoModificado[0] + projetoModificado[3] + projetoModificado[4] + projetoModificado[5]
                    this[index].dataCadastroInteiro = parseInt(projetoJuncao)
                }, this.listaPropostasNota);
            },
            async preencherLista() {
                this.dialogCarregar = true
                this.listaPropostasNota = await this.bucarPropostasNotas()
                this.parseDataParaInteiro()
                this.listaPropostas = await this.ordenarListaNotaMaior()
                this.dialogCarregar = false
            },
            verMais(item) {

            },


        }
    }
</script>

<style scoped>

</style>