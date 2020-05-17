<template>
    <ul class="ml-3">
        <li>Desenvolver uma aplicação web responsável por classificar as propostas de uma licitação.</li>
        <li class="my-3">
            Licitação
            <ul style="list-style-type:circle">
                <li>Deve conter os atributo
                    <ul style="list-style-type:square">
                        <template v-for="atributo in atributosLicitacao">
                            <li>{{atributo}}}</li>
                        </template>
                    </ul>
                </li>
                <li>Incluir, excluir, atualizar</li>
            </ul>
        </li>
        <li>Proposta
            <ul style="list-style-type:circle">
                <li>Deve conter os atributos
                    <ul style="list-style-type:square">
                        <template v-for="atributo in atributosProposta">
                            <li>{{atributo}}</li>
                        </template>
                    </ul>
                </li>
                <li>Incluir, excluir, atualizar</li>
            </ul>
        </li>
        <li>Regras de classificação
            <ul style="list-style-type:circle">
                <li>Para licitações do tipo "Nota Preço" classificar a colocação pela nota, preço e data cadastro
                    <div style="background: #cccccc;">
                        <template v-for="classificacao in classificacaoNotaPreco">
                            <p>{{classificacao}}</p>
                        </template>
                    </div>
                </li>
                <li>Para licitações do tipo "Menor Preço" classificar a colocação pelo preço e data cadastro
                    <div style="background: #cccccc;">
                        <template v-for="classificacao in classificacaoMenorPreco">
                            <p>{{classificacao}}</p>
                        </template>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</template>

<script>
    export default {
        name: 'ListaIncio',
        data: () => ({
            atributosProposta: [
                'fornecedor (string)',
                'nota (bigdecimal) somente para tipo NOTA_PRECO',
                'preço (bigdecimal)',
                'data cadastro (string)',
                'classificação (integer)',
                'licitação (objeto)'
            ],
            atributosLicitacao: [
                'descrição (string)',
                'tipo classificação (enum ["Menor Preço", "Nota Preço"])'
            ],
            classificacaoNotaPreco: [
                'Fornecedor A, nota 8.0, preço 110.00, data 23/10/2019 10:00',
                'Fornecedor B, nota 8.0, preço 110.00, data 23/10/2019 10:30',
                'Fornecedor C, nota 8.9, preço 115.00, data 23/10/2019 10:40',
                'Fornecedor D, nota 7.5, preço 90.00, data 23/10/2019 10:50',
                'A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B, Fornecedor D'
            ],
            classificacaoMenorPreco: [
                'Fornecedor A, preço 115.00, data 23/10/2019 10:00',
                'Fornecedor B, preço 115.00, data 23/10/2019 10:30',
                'Fornecedor C, preço 100.00, data 23/10/2019 10:40',
                'A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B'
            ]
        })
    }
</script>

<style scoped>

</style>