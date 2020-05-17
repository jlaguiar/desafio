<template>
    <card-titulo :titulo="titulo">
        <v-card-text>
            <v-layout row justify-start>
                <v-col cols="12" sm="6" xs="12">
                    <v-text-field
                            v-model="novaProposta.fornecedor">
                        <template slot="label">
                            Fornecedor <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                        </template>
                    </v-text-field>
                </v-col>
                <v-col cols="12" sm="6" xs="12">
                    <v-select
                            v-model="novaProposta.licitacao.tipoClassificacao"
                            :items="tiposClassificacao"
                            hide-details>
                        <template slot="label">
                            Tipo de classificação <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                        </template>
                    </v-select>
                </v-col>
                <v-col cols="12" sm="12">
                    <v-text-field
                            v-model="novaProposta.licitacao.descricao">
                        <template slot="label">
                            Descrição da licitação <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                        </template>
                    </v-text-field>
                </v-col>
                <v-col cols="12" sm="6" xs="12"
                       v-if="novaProposta.licitacao.tipoClassificacao === 'Nota preço'">
                    <v-text-field
                            v-model="novaProposta.nota">
                        <template slot="label">
                            Nota <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                        </template>
                    </v-text-field>
                </v-col>
                <v-col cols="12" sm="6" xs="12">
                    <v-text-field
                            v-model="novaProposta.preco">
                        <template slot="label">
                            Preço <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                        </template>
                    </v-text-field>
                </v-col>
            </v-layout>
        </v-card-text>
        <v-card-actions class="justify-center">
            <v-btn large text color="#aaaaaa" elevation="0" class="mr-3"
                   @click="limpar">Limpar
            </v-btn>
            <v-btn large text color="white" style="background: #fb8c00"
                   elevation="0" @click="salvarProposta">Salvar
            </v-btn>
        </v-card-actions>

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

    export default {
        name: 'CadastrarProposta',
        components: {CardTitulo},
        props: {
            proposta: {
                required: false,
                default: () => ({
                    fornecedor: '',
                    nota: '',
                    preco: '',
                    dataCadastro: '',
                    licitacao: {
                        descricao: '',
                        tipoClassificacao: ''
                    }
                })
            }
        },
        data: () => ({
            ehEditar: false,
            dialog: false,
            titulo: '',
            novaProposta: {
                fornecedor: '',
                nota: '',
                preco: '',
                dataCadastro: '',
                licitacao: {
                    descricao: '',
                    tipoClassificacao: ''
                }
            },
            tiposClassificacao: ['Menor preço', 'Nota preço']
        }),
        mounted() {
            this.preencherNovaProposta()
        },
        methods: {
            ...mapActions(['salvar', 'editar']),
            limpar() {
                this.novaProposta.fornecedor = ''
                this.novaProposta.nota = ''
                this.novaProposta.preco = ''
                this.novaProposta.licitacao.descricao = ''
                this.novaProposta.licitacao.tipoClassificacao = ''
            },
            async salvarProposta() {
                if(this.validarCampos()){
                    if (!this.ehEditar) {
                        this.ajustarClassificacao()
                        this.dialog = true
                        await this.salvar(this.novaProposta)
                        this.limpar()
                        this.dialog = false
                    } else {
                        this.editar(this.novaProposta)
                    }
                }else{
                    console.log('nao pode')
                }

            },
            ajustarClassificacao() {
                this.novaProposta.licitacao.tipoClassificacao = this.novaProposta.licitacao.tipoClassificacao === 'Menor preço' ? 'MENOR_PRECO' : 'NOTA_PRECO'
            },
            preencherNovaProposta() {
                if (this.proposta.fornecedor !== '' && this.proposta.fornecedor !== undefined) {
                    this.titulo = 'Editar proposta'
                    this.editar = true
                    this.novaProposta.id = this.proposta.id
                    this.novaProposta.fornecedor = this.proposta.fornecedor
                    this.novaProposta.preco = this.proposta.preco
                    this.novaProposta.licitacao.descricao = this.proposta.licitacao.descricao
                    if (this.proposta.licitacao.tipoClassificacao === 'NOTA_PRECO') {
                        this.novaProposta.nota = this.proposta.nota
                    }
                    this.novaProposta.licitacao.tipoClassificacao = this.proposta.licitacao.tipoClassificacao === 'MENOR_PRECO' ? 'Menor preço' : 'Nota preço'
                } else {
                    this.titulo = 'Cadastrar proposta'
                    this.limpar()
                }
            },
            validarCampos() {
                if (this.novaProposta.fornecedor === '' || this.novaProposta.preco === ''
                    || this.novaProposta.licitacao.tipoClassificacao === '' || this.novaProposta.licitacao.descricao === '') {
                    return false
                }else{
                    return true
                }
            }
        }
    }
</script>

<style scoped>

</style>