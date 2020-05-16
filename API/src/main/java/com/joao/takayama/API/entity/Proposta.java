package com.joao.takayama.API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proposta {

    private String id;

    private String fornecedor;

    private BigDecimal nota;

    private BigDecimal preco;

    private String dataCadastro;

    private Integer classificacao;

    private Licitacao licitacao;
}
