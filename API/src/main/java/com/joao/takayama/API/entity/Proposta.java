package com.joao.takayama.API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Proposta {

    @Id
    private String id;

    private String fornecedor;

    private BigDecimal nota;

    private BigDecimal preco;

    private String dataCadastro;

    private Integer classificacao;

    private Licitacao licitacao;
}
