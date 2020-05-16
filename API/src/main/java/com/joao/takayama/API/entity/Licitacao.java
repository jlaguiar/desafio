package com.joao.takayama.API.entity;

import com.joao.takayama.API.entity.enumeration.EnumClassificacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Licitacao {

    private String descricao;

    private EnumClassificacao classificacao;
}
