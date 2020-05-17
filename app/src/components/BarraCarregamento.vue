<template>
    <v-dialog
            v-model="dialog"
            hide-overlay
            persistent
            width="300">
        <v-card
                color="black"
                dark>
            <v-card-text>
                {{label}}
                <v-progress-linear
                        indeterminate
                        color="white"
                        class="mb-0"
                ></v-progress-linear>
            </v-card-text>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        name: 'BarraCarregamento',
        props: ['dialog', 'label'],
    }
</script>

<style scoped>

</style>