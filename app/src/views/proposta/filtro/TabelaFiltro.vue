<template>
    <card-titulo titulo="Classificação nota menor">
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
                            @click="verMais(item)">
                        visibility
                    </v-icon>
                </template>
            </v-data-table>
            <div class="text-center pt-2">
                <v-pagination v-model="pagina" :length="quantidadePaginas" color="black"></v-pagination>
            </div>
        </v-card-text>
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../../components/CardTitulo'
    import BarraCarregamento from '../../../components/BarraCarregamento'

    export default {
        name: "TabelaFIltro",
        components: {CardTitulo,BarraCarregamento},
        props: ['propostasLabel','listaPropostas'],
        data: () => ({
            quantidadePaginas: 0,
            itensPorPagina: 10,
            pagina: 1,
            listaPropostas: [],
            listaPropostasNota: []
        }),
    }
</script>

<style scoped>

</style>