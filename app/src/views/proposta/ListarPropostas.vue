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
                    <v-icon small class="mr-2" color="#fb8c00"
                            @click="editarProposta(item)">
                        mdi-pencil
                    </v-icon>
                    <v-icon small @click="verificarExcluir(item)"
                            color="rgb(199,15,15)">
                        mdi-delete
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
        <v-dialog
                v-model="dialog"
                hide-overlay
                persistent
                width="300">
            <v-card
                    color="black"
                    dark>
                <v-card-text>
                    Excluindo
                    <v-progress-linear
                            indeterminate
                            color="white"
                            class="mb-0"
                    ></v-progress-linear>
                </v-card-text>
            </v-card>
        </v-dialog>
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../components/CardTitulo'
    import {mapActions} from 'vuex'
    import DialogExclusao from './DialogExclusao'

    export default {
        name: 'ListarPropostas',
        components: {CardTitulo, DialogExclusao},
        data: () => ({
            dialog: false,
            propostaExcluir: {},
            dialogVerificacaoExcluir: false,
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
            listaPropostas: [],
        }),
        mounted() {
            this.preencherLista()
        },
        methods: {
            ...mapActions(['buscarPropostas','excluir']),
            editarProposta(proposta) {
                this.$router.push({name: 'cadastrarPropostaParametros', params: {proposta}})
            },
            fecharDialog() {
                this.dialogVerificacaoExcluir = false
            },
            verificarExcluir(proposta) {
                this.dialogVerificacaoExcluir = true
                this.propostaExcluir = proposta
            },
            async excluirProposta() {
                this.fecharDialog()
                this.dialog = true
                await this.excluir(this.propostaExcluir.id)
                this.listaPropostas = await this.buscarPropostas()
                this.dialog = false
            },
            async preencherLista() {
                this.listaPropostas = await this.buscarPropostas()
            }

        }
    }
</script>

<style scoped>

</style>