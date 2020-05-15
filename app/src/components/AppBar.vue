<template>
    <div>
        <v-app-bar color="dark" dense dark>
            <v-app-bar-nav-icon @click="controleNavigation = true">
            </v-app-bar-nav-icon>
            <v-toolbar-title>Desafio AZI</v-toolbar-title>
        </v-app-bar>
        <v-navigation-drawer
                color="black"
                v-model="controleNavigation"
                absolute temporary>
            <v-list nav dense>
                <v-list-item v-for="acao in acoes" @click="chamarRota(acao)">
                    <v-list-item-icon>
                        <v-icon color="white">{{acao.icon}}</v-icon>
                    </v-list-item-icon>
                    <v-list-item-title style="color: white; font-size: 15px"  >{{acao.label}}</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
    export default {
        name: "AppBar",
        data: () =>({
            controleNavigation: false,
            acoes: [
                {
                    label: 'Desafio AZI',
                    icon: ''
                },
                {
                    label: 'Inicio',
                    icon: 'mdi-home'
                },
                {
                    label: 'Cadastrar proposta',
                    icon: 'add'
                },
                {
                    label: 'Listar propostas',
                    icon: 'list'
                },
                {
                    label: 'Classificar nota preço',
                    icon: 'star_border'
                },
                {
                    label: 'Classificar menor preço',
                    icon: 'star_border'
                }
            ]
        }),
        methods: {
            chamarRota(acao){
                if(acao.label === 'Cadastrar proposta'){
                    this.$route.push()
                }
            }
        }
    }
</script>

<style scoped>

</style>