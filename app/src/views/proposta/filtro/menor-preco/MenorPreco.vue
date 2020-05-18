<template>
    <div>
        <tabela-filtro label="Classificação menor preço"
                       :propostas-label="propostasLabel"
                       :lista-propostas="listaPropostas"/>
        <barra-carregamento :dialog="dialogCarregar"
                            label="Carregando"/>
    </div>
</template>

<script>
    import {mapActions} from 'vuex'
    import BarraCarregamento from '../../../../components/BarraCarregamento'
    import TabelaFiltro from '../commons/TabelaFiltro'

    export default {
        name: 'MenorPreco',
        components: {BarraCarregamento, TabelaFiltro},
        data: () => ({
            dialogCarregar: false,
            propostasLabel: [
                {text: 'Forncedor', value: 'fornecedor', sortable: false},
                {text: 'Preço (R$)', value: 'preco', sortable: false},
                {text: 'Data', value: 'dataCadastro', sortable: false},
                {text: 'Ações', value: 'actions', sortable: false},
            ],
            listaPropostas: [],
            listaPropostasPreco: []
        }),
        async mounted() {
            await this.preencherLista()
        },
        methods: {
            ...mapActions(['bucarPropostasPrecos']),
            async ordenarListaMenorPreco() {
                await this.listaPropostasPreco.sort(function (valor1, valor2) {
                    if (valor1.preco < valor2.preco) {
                        return -1
                    } else if (valor1.preco > valor2.preco) {
                        return 1
                    } else {
                        if (valor1.dataCadastroInteiro < valor2.dataCadastroInteiro) {
                            return -1
                        } else if (valor1.dataCadastroInteiro > valor2.dataCadastroInteiro) {
                            return 1
                        } else {
                            return 0
                        }
                    }
                })
                return this.listaPropostasPreco
            },
            parseDataParaInteiro() {
                this.listaPropostasPreco.forEach(function (element, index) {
                    let projetoModificado = this[index].dataCadastro.replace(/\D/g, ' ')
                    projetoModificado = projetoModificado.split(' ')
                    let projetoJuncao = projetoModificado[2]
                    projetoJuncao = projetoJuncao + projetoModificado[1] + projetoModificado[0] + projetoModificado[3] + projetoModificado[4] + projetoModificado[5]
                    this[index].dataCadastroInteiro = parseInt(projetoJuncao)
                }, this.listaPropostasPreco);
            },
            async preencherLista() {
                this.dialogCarregar = true
                this.listaPropostasPreco = await this.bucarPropostasPrecos()
                this.parseDataParaInteiro()
                this.listaPropostas = await this.ordenarListaMenorPreco()
                this.dialogCarregar = false
            },
            verMais(item) {

            },
        }
    }
</script>

<style scoped>

</style>