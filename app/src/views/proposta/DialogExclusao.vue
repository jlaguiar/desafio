<template>
    <v-dialog v-model="dialogVerificacaoExcluir" width="400" persistent>
        <v-card color="black">
            <v-card-title style="color: white" headline>Excluir proposta
                <v-icon size="36" color="rgb(199,15,15)">mdi-delete</v-icon> ?
            </v-card-title>
            <v-card-text style="color: white">
                Ao excluir a proposta não é possivél recuperá-la.<br/>
                Deseja exclui-la mesmo assim?
            </v-card-text>
            <v-card-actions class="justify-center">
                <v-btn elevation="0" text color="#fb8c00" @click="fecharDialog">Cancelar</v-btn>
                <v-btn elevation="0" text color="white" @click="excluir">Excluir</v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        name: 'DialogExclusao',
        props: ['dialogVerificacaoExcluir', 'proposta'],
        methods: {
            fecharDialog(){
                this.$emit('fecharDialog')
            },
            excluir(){
                this.$emit('excluirProposta', this.proposta)
            }
        }
    }
</script>

<style scoped>

</style>