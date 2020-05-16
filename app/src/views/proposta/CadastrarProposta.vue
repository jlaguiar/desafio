<template>
    <div class="mt-6">
        <v-layout justify-center align-center wrap>
            <v-card class="text-center mt-12" width="800" color="rgba(245,245,245,0.3)">
                <v-card-title class="justify-center font-weight-bold">Cadastrar proposta</v-card-title>
                <div style="border: 1px solid #cccccc"></div>
                <v-card-text>
                    <v-layout row justify-start>
                        <v-col cols="12" sm="6" xs="12">
                            <v-text-field
                                    v-model="novaProposta.fornecedor"
                                    :rules="[requeridVazio]">
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
                                    v-model="novaProposta.licitacao.descricao"
                                    :rules="[requeridVazio]">
                                <template slot="label">
                                    Descrição da licitação <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                                </template>
                            </v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" xs="12"
                               v-if="novaProposta.licitacao.tipoClassificacao === 'Nota preço'">
                            <v-text-field
                                    v-model="novaProposta.nota"
                                    :rules="[requeridVazio]">
                                <template slot="label">
                                    Nota <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                                </template>
                            </v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" xs="12">
                            <v-text-field
                                    v-model="novaProposta.preco"
                                    :rules="[requeridVazio]">
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
                           elevation="0" @click="salvar">Salvar
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-layout>
    </div>
</template>

<script>
    export default {
        name: 'CadastrarProposta',
        data: () => ({
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
            requeridVazio: value => !!value || 'Nao pode ser vazio',
            tiposClassificacao: ['Menor preço', 'Nota preço'],
        }),
        methods: {
            limpar() {
                this.novaProposta.fornecedor = ''
                this.novaProposta.nota = ''
                this.novaProposta.preco = ''
                this.novaProposta.licitacao.descricao = ''
                this.novaProposta.licitacao.tipoClassificacao = ''
            },
            salvar() {

            }
        }
    }
</script>

<style scoped>

</style>