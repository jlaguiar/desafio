<template>
    <div>
        <tabela-f-iltro />
        <barra-carregamento :dialog="dialogCarregar"
                            label="Carregando"/>
    </div>

</template>

<script>
    import CardTitulo from '../../../components/CardTitulo'
    import {mapActions} from 'vuex'
    import BarraCarregamento from '../../../components/BarraCarregamento'
    import TabelaFIltro from "../filtro/TabelaFiltro";
    export default {
        name: 'MenorPreco',
        components: {CardTitulo,BarraCarregamento,TabelaFIltro},
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