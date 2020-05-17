<template>
    <card-titulo titulo="Maior nota filtro">
        <v-card-text>
            <v-data-table
                    :headers="propostasLabel"
                    :items="listaPropostas"
                    sort-by="fornecedor"
                    class="elevation-1"
                    :page.sync="pagina"
                    hide-default-footer
                    @page-count="quantidadePaginas = $event"
                    :items-per-page="itensPorPagina"
            >
                <template v-slot:item.actions="{item}">
                    <v-icon small class="mr-2" color="#fb8c00"
                            @click="verMais(item)">
                        visibility
                    </v-icon>
                </template>
            </v-data-table>
            <div class="text-center pt-2">
                <v-pagination v-model="pagina" :length="quantidadePaginas"></v-pagination>
            </div>
        </v-card-text>
        <dialog-exclusao
                :dialog-verificacao-excluir="dialogVerificacaoExcluir"
                @fecharDialog="fecharDialog"
                @excluirProposta="excluirProposta"
        />
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../../components/CardTitulo'
    export default {
        name: 'MaiorNota',
        components: {CardTitulo},
        data: () => ({
            quantidadePaginas: 0,
            itensPorPagina: 10,
            pagina: 1,
            propostasLabel: [
                {text: 'Forncedor', value: 'fornecedor', sortable: false},
                {text: 'Nota', value: 'nota', sortable: false},
                {text: 'Preço (R$)', value: 'preco', sortable: false},
                {text: 'Data', value: 'dataCadastro', sortable: false},
                {text: 'Ações', value: 'actions', sortable: false},
            ],
            listaPropostas: [],
        }),
        mounted() {

        },
        methods: {
            verMais(){

            }
        }
    }
</script>

<style scoped>

</style>