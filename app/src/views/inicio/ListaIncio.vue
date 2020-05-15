<template>
    <ul class="ml-3">
        <li>Desenvolver uma aplicação web responsável por classificar as propostas de uma licitação.</li>
        <li class="my-3">
            Licitação
            <ul style="list-style-type:circle">
                <li>Deve conter os atributo
                    <ul style="list-style-type:circle">
                        <ul style="list-style-type:square">
                            <li>descrição (string)</li>
                            <li>tipo classificação (enum ["Menor Preço", "Nota Preço"])</li>
                        </ul>
                    </ul>
                </li>
                <li>Incluir, excluir, atualizar</li>
            </ul>
        </li>
        <li>Proposta
            <ul style="list-style-type:circle">
                <li>Deve conter os atributos
                    <ul style="list-style-type:circle">
                        <ul style="list-style-type:square">
                            <li>fornecedor (string)</li>
                            <li>nota (bigdecimal) somente para tipo NOTA_PRECO</li>
                            <li>preço (bigdecimal)</li>
                            <li>data cadastro (string)</li>
                            <li>classificação (integer)</li>
                            <li>licitação (objeto)</li>
                        </ul>
                    </ul>
                </li>
                <li>Incluir, excluir, atualizar</li>
            </ul>
        </li>
        <li>Regras de classificação
            <ul style="list-style-type:circle">
                <li>Para licitações do tipo "Nota Preço" classificar a colocação pela nota, preço e data cadastro
                    <div style="background: #cccccc;" class="mr-12">
                        <p>Fornecedor A, nota 8.0, preço 110.00, data 23/10/2019 10:00</p>
                        <p>Fornecedor B, nota 8.0, preço 110.00, data 23/10/2019 10:30
                        </p>
                        <p>Fornecedor C, nota 8.9, preço 115.00, data 23/10/2019 10:40
                        </p>
                        <p>Fornecedor D, nota 7.5, preço 90.00, data 23/10/2019 10:50
                        </p>
                        <p>A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B, Fornecedor D
                        </p>
                    </div>
                </li>
                <li>Para licitações do tipo "Menor Preço" classificar a colocação pelo preço e data cadastro
                    <div style="background: #cccccc;" class="mr-9">
                        <p>Fornecedor A, preço 115.00, data 23/10/2019 10:00
                        </p>
                        <p>Fornecedor B, preço 115.00, data 23/10/2019 10:30
                        </p>
                        <p>Fornecedor C, preço 100.00, data 23/10/2019 10:40
                        </p>
                        <p>A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B
                        </p>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</template>

<script>
    export default {
        name: "ListaIncio"
    }
</script>

<style scoped>

</style>