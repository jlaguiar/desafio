<template>
    <v-tooltip top>
        <template v-slot:activator="{ on }">
            <v-icon size="15" v-on="on" color="#fb8c00">info</v-icon>
        </template>
        <span>Utilizar <span style="color: red; font-size: 30px">.</span>  para valores decimais </span>
    </v-tooltip>
</template>

<script>
    export default {
        name: 'TooltipNumeros'
    }
</script>

<style scoped>

</style>