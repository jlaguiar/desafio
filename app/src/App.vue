<template>
  <v-app>
    <div>
      <v-icon large color="blue darken-2">mdi-done</v-icon>
      <span>
        <v-icon>done</v-icon>
      </span>
    </div>

  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld';

export default {
  name: 'App',

  components: {
    HelloWorld,
  },

  data: () => ({
    //
  }),
};
</script>
