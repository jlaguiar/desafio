<template>
    <card-titulo titulo="Inicio">
        <v-card-text>
            <v-layout row justify-start>
                <h4 class="ml-3 mb-3">A proposta desse projeto é :</h4>
                <lista-incio/>
            </v-layout>
        </v-card-text>
    </card-titulo>
</template>

<script>
import ListaIncio from './inicio/ListaIncio'
import CardTitulo from '../components/CardTitulo'
export default {
  name: 'Inicio',
  components: {
      ListaIncio, CardTitulo
  },
}
</script>
