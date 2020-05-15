<template>
  <div>
    <v-app-bar color="dark" dense dark>
      <v-app-bar-nav-icon @click="drawer = true">
      </v-app-bar-nav-icon>
      <v-toolbar-title>Desafio AZI</v-toolbar-title>
    </v-app-bar>
    <v-navigation-drawer
            color="black"
            v-model="drawer"
            absolute temporary>
      <v-list nav dense>
        <v-list-item-group
                v-model="group">
          <v-list-item v-for="acao in acoes">
            <v-list-item-icon>
              <v-icon color="white">{{acao.icon}}</v-icon>
            </v-list-item-icon>
            <v-list-item-title style="color: white; font-size: 15px">{{acao.label}}</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>

export default {
  name: 'Inicio',
  components: {
  },
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
        icon: 'mdi-home'
      },
      {
        label: 'Listar propostas',
        icon: 'mdi-home'
      },
      {
        label: 'Classificar nota preço',
        icon: 'mdi-home'
      },
      {
        label: 'Classificar menor preço',
        icon: 'mdi-home'
      }
    ]
  })
}
</script>
