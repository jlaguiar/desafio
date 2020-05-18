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
                {text: 'Nota', value: 'nota', sortable: false},
                {text: 'Preço (R$)', value: 'preco', sortable: false},
                {text: 'Data', value: 'dataCadastro', sortable: false},
                {text: 'Ações', value: 'actions', sortable: false},
            ],
            listaPropostas: [],
            listaPropostasPreco: []
        }),
    }
</script>

<style scoped>

</style>