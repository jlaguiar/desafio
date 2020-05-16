<template>
    <div>
        <v-app-bar color="dark" dense dark>
            <v-app-bar-nav-icon @click="controleNavigation = true">
            </v-app-bar-nav-icon>
            <v-toolbar-title>Desafio <span style="color: #fb8c00">AZI</span></v-toolbar-title>
        </v-app-bar>
        <v-navigation-drawer
                color="black"
                v-model="controleNavigation"
                absolute temporary>
            <v-list nav dense>
                <v-list-item v-for="acao in acoes" :key="acao.label" @click="chamarRota(acao)">
                    <v-list-item-icon>
                        <v-icon color="white">{{acao.icon}}</v-icon>
                    </v-list-item-icon>
                    <v-list-item-title style="color: white; font-size: 15px">{{acao.label}}</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
    export default {
        name: "AppBar",
        data: () => ({
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
            chamarRota(acao) {
                if (acao.label === 'Inicio') {
                    const path = `/`
                    if (this.$route.path !== path) this.$router.push(path)
                } else if (acao.label === 'Cadastrar proposta') {
                    const path = `/cadastrar-proposta`
                    const regexReload = /cadastrar.*/gi
                    if (this.$route.path.match(regexReload)) {
                        this.$router.go()
                    } else if (this.$route.path !== path) {
                        this.$router.push(path)
                    }
                } else if (acao.label === 'Listar propostas') {
                    const path = `/listar-propostas`
                    if (this.$route.path !== path) this.$router.push(path)
                }
            }
        }
    }
</script>

<style scoped>

</style>