<template>
    <card-titulo titulo="Listar propostas">
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
                    <v-icon small class="mr-2" color="blue"
                            @click="editarProposta(item)">
                        mdi-pencil
                    </v-icon>
                    <v-icon small @click="excluirProposta(item)"
                            color="rgb(199,15,15)">
                        mdi-delete
                    </v-icon>
                </template>
            </v-data-table>
            <div class="text-center pt-2">
                <v-pagination v-model="pagina" :length="quantidadePaginas"></v-pagination>
            </div>
        </v-card-text>
    </card-titulo>

</template>

<script>
    import CardTitulo from '../../components/CardTitulo'

    export default {
        name: 'ListarPropostas',
        components: {CardTitulo},
        data: () => ({
            dialog: false,
            quantidadePaginas: 0,
            itensPorPagina: 10,
            pagina: 1,
            propostasLabel: [
                {
                    text: 'Forncedor',
                    sortable: false,
                    value: 'fornecedor',
                },
                {text: 'Nota', value: 'nota'},
                {text: 'Preço (R$)', value: 'preco'},
                {text: 'Data', value: 'dataCadastro', sortable: false},
                {text: 'Ações', value: 'actions', sortable: false},
            ],
            listaPropostas: [
                {
                    fornecedor: 'A',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'B',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Menor preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },
                {
                    fornecedor: 'C',
                    nota: '8.0',
                    preco: '115,00',
                    dataCadastro: '23/10/2019 10:00',
                    licitacao: {
                        descricao: 'Uma descrição',
                        tipoClassificacao: 'Nota preço'
                    }
                },

            ],
        }),
        methods: {
            editarProposta(proposta) {
                this.$router.push({name: 'cadastrarPropostaParametros', params: {proposta}})
            },
            excluirProposta() {

            }

        }
    }
</script>

<style scoped>

</style>