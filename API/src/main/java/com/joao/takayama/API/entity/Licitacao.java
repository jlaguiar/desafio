package com.joao.takayama.API.entity;

import com.joao.takayama.API.entity.enumeration.EnumClassificacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Licitacao {

    private String id;

    private String descricao;

    private EnumClassificacao classificacao;
}
