<template>
    <v-dialog v-model="dialog" width="600" persistent>
        <v-card>
            <v-card-text>
                <v-layout row justify-start>
                    <v-col cols="12" sm="6" xs="12">
                        <v-text-field
                                disabled
                                v-model="proposta.fornecedor">
                            <template slot="label">
                                Fornecedor <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                            </template>
                        </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" xs="12">
                        <v-select
                                disabled
                                hide-details>
                            <template slot="label">
                                {{proposta.licitacao.tipoClassificacao}}
                            </template>
                        </v-select>
                    </v-col>
                    <v-col cols="12" sm="12">
                        <v-textarea
                                label="Descrição"
                                v-model="proposta.licitacao.descricao"
                                auto-grow
                                rows="1"
                                disabled
                        ></v-textarea>
                    </v-col>
                    <v-col cols="12" sm="6" xs="12">
                        <v-text-field
                                disabled
                                v-model="proposta.preco">
                            <template slot="label">
                                Preço <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                            </template>
                        </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" xs="12"
                           v-if="proposta.licitacao.tipoClassificacao === 'Nota preço'">
                        <v-text-field
                                disabled
                                v-model="proposta.nota">
                            <template slot="label">
                                Nota <span style="color: rgb(199,15,15); font-size: 12px">*</span>
                            </template>
                        </v-text-field>
                    </v-col>
                </v-layout>
            </v-card-text>
            <v-card-actions class="justify-center">
                <v-btn color="#fb8c00" @click="$emit('fecharDialog')" elevation="0">Fechar</v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        name: 'DialogVisualizar',
        props: ['dialog', 'propostaDialog'],
        data: () => ({
            proposta: {
                fornecedor: '',
                nota: '',
                preco: '',
                dataCadastro: '',
                licitacao: {
                    descricao: '',
                    tipoClassificacao: ''
                }
            },
        }),
        watch:{
            'dialog'(){
                this.proposta = this.propostaDialog
            }
        }
    }
</script>

<style scoped>

</style>