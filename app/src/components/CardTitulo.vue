<template>
    <div class="my-12">
        <v-layout justify-center wrap>
            <v-card width="800" class="mt-12">
                <v-card-title class="justify-center font-weight-bold text-uppercase">{{titulo}}</v-card-title>
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