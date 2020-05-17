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
        <barra-carregamento :dialog="dialogCarregar"
                            label="Excluindo"/>
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../components/CardTitulo'
    import {mapActions} from 'vuex'
    import DialogExclusao from './DialogExclusao'
    import BarraCarregamento from '../../components/BarraCarregamento'

    export default {
        name: 'ListarPropostas',
        components: {CardTitulo, DialogExclusao, BarraCarregamento},
        data: () => ({
            dialogCarregar: false,
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
            ...mapActions(['buscarPropostas', 'excluir']),
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
                this.dialogCarregar = true
                await this.excluir(this.propostaExcluir.id)
                this.listaPropostas = await this.buscarPropostas()
                this.dialogCarregar = false
            },
            async preencherLista() {
                this.listaPropostas = await this.buscarPropostas()
            }

        }
    }
</script>

<style scoped>

</style>