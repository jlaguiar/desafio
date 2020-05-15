<template>
    <v-layout column justify-center>
        <v-flex>
            <div class="text-center">
                <h2 class="mt-3">Inicio</h2>
            </div>
            <div>
                <h4 class="ml-3 mb-3">A proposta desse projeto é :</h4>
               <lista-incio/>
            </div>
        </v-flex>

    </v-layout>
</template>

<script>
import ListaIncio from './inicio/ListaIncio'
export default {
  name: 'Inicio',
  components: {
      ListaIncio
  },
}
</script>
