import Vue from 'vue';
import Vuetify from 'vuetify/lib';
import "@mdi/font/css/materialdesignicons.css";

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        primary: "#A01500",
        azul: "#087196",
        cinza_claro: "#AFAFAF",
        cinza_escuro: "#595959"
    },
    icons: {
        iconfont: 'mdi'
    },
});
