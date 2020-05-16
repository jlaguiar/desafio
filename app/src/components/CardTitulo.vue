<template>
    <div class="my-12">
        <v-layout justify-center wrap>
            <v-card width="800">
                <v-card-title class="justify-center font-weight-bold">{{titulo}}</v-card-title>
                <div style="border: 1px solid #cccccc"></div>
                <slot></slot>
            </v-card>
        </v-layout>
    </div>
</template>

<script>
    export default {
        name: 'CardTitulo',
        props: ['titulo']
    }
</script>

<style scoped>

</style>