<template>
    <card-titulo :titulo="label">
        <v-card-text>
            <v-data-table
                    :headers="propostasLabel"
                    :items="listaPropostas"
                    :page.sync="pagina"
                    hide-default-footer
                    @page-count="quantidadePaginas = $event"
                    :items-per-page="itensPorPagina">
                <template v-slot:item.actions="{item}">
                    <v-icon small class="mr-2" color="#fb8c00"
                            @click="abrirVisualizador(item)">
                        visibility
                    </v-icon>
                </template>
            </v-data-table>
            <div class="text-center pt-2">
                <v-pagination v-model="pagina" :length="quantidadePaginas" color="black"></v-pagination>
            </div>
        </v-card-text>
        <dialog-visualizar  :dialog="abrirDialogVisualizador"
                            :propostaDialog="propostaVisualizar"
                            @fecharDialog="fecharVisualizador"/>
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../../../components/CardTitulo'
    import DialogVisualizar from './DialogVisualizar'

    export default {
        name: 'TabelaFIltro',
        components: {CardTitulo,DialogVisualizar},
        props: {
            propostasLabel: {
                required: true,
                default: []
            },
            listaPropostas: {
                type: Array,
                required: true,
                default: []
            },
            label:{
                required: true,
                default: 'Classificação'
            }
        },
        data: () => ({
            quantidadePaginas: 0,
            itensPorPagina: 10,
            pagina: 1,
            abrirDialogVisualizador: false,
            propostaVisualizar: {

            }
        }),
        methods: {
            fecharVisualizador(){
                this.abrirDialogVisualizador = false
            },
            abrirVisualizador(proposta){
                proposta.licitacao.tipoClassificacao = proposta.licitacao.tipoClassificacao === 'MENOR_PRECO'  ? 'Menor preço' : 'Nota preço'
                this.propostaVisualizar = proposta
                setTimeout(this.abrirDialogVisualizador = true,1000)


            }
        }
    }
</script>

<style scoped>

</style>