<template>
    <card-titulo titulo="LISTAR PROPOSTAS">
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
                <v-pagination v-model="pagina" :length="quantidadePaginas" color="black"></v-pagination>
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
            labelDialogCarregar: '',
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
                {text: 'Tipo classificação', value: 'licitacao.tipoClassificacao', sortable: false},
                {text: 'Preço (R$)', value: 'preco', sortable: false},
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
            async excluirProposta() {
                try{
                    this.fecharDialog()
                    this.labelDialogCarregar = 'Excluindo'
                    this.dialogCarregar = true
                    await this.excluir(this.propostaExcluir.id)
                    this.listaPropostas = await this.buscarPropostas()
                    this.dialogCarregar = false
                    this.$toasted.global.defaultSuccess()
                }catch (e) {
                    this.dialogCarregar = false
                    this.$toasted.global.defaultError()
                }
            },
            fecharDialog() {
                this.dialogVerificacaoExcluir = false
            },
            async preencherLista() {
                this.labelDialogCarregar = 'Excluindo'
                this.dialogCarregar = true
                this.listaPropostas = await this.buscarPropostas()
                this.dialogCarregar = false
            },
            verificarExcluir(proposta) {
                this.dialogVerificacaoExcluir = true
                this.propostaExcluir = proposta
                this.dialogCarregar = false
            }
        }
    }
</script>

<style scoped>

</style>