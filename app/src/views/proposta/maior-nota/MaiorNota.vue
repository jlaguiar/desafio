<template>
    <card-titulo titulo="Maior nota, menor preço, menor data">
        <v-card-text>
            <v-data-table
                    :headers="propostasLabel"
                    :items="listaPropostas"
                    class="elevation-1"
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
        <barra-carregamento :dialog="dialogCarregar"
                            label="Carregando"/>
    </card-titulo>
</template>

<script>
    import CardTitulo from '../../../components/CardTitulo'
    import {mapActions} from 'vuex'

    export default {
        name: 'MaiorNota',
        components: {CardTitulo},
        data: () => ({
            dialogCarregar: false,
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
            listaPropostasNota: []
        }),
        async mounted() {
            this.dialogCarregar = true
            await this.preencherLista()
            this.dialogCarregar = false
        },
        computed: {

        },
        methods: {
            ...mapActions(['bucarPropostasNotas']),
            verMais() {
            },
            async preencherLista() {
                this.listaPropostasNota = await this.bucarPropostasNotas()
                this.parseDataParaInteiro()
                this.listaPropostas = await this.ordenarListaNotaMaior()
            },
            async ordenarListaNotaMaior(){
                await this.listaPropostasNota.sort(function(valor1, valor2) {
                    if(valor1.nota > valor2.nota){
                        return -1
                    }else if(valor1.nota < valor2.nota){
                        return 1
                    }else{
                        if(valor1.preco < valor2.preco){
                            return -1
                        }else if(valor1.preco > valor2.preco){
                            return 1
                        }else{
                            debugger
                            if(valor1.dataCadastroInteiro < valor2.dataCadastroInteiro){
                                return -1
                            }else if(valor1.dataCadastroInteiro > valor2.dataCadastroInteiro){
                                return 1
                            }else{
                                return 0
                            }
                        }
                    }
                })
                return this.listaPropostasNota
            },
            parseDataParaInteiro(){
                this.listaPropostasNota.forEach(function(element,index){
                    let projetoModificado  = this[index].dataCadastro.replace(/\D/g, ' ')
                    projetoModificado = projetoModificado.split(' ')
                    let projetoJuncao = projetoModificado[2]
                    projetoJuncao = projetoJuncao + projetoModificado[1]+ projetoModificado[0] + projetoModificado[3] + projetoModificado[4] + projetoModificado[5]
                    this[index].dataCadastroInteiro = parseInt(projetoJuncao)
                }, this.listaPropostasNota);
            }

        }
    }
</script>

<style scoped>

</style>