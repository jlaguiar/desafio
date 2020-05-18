package com.joao.takayama.API.propostas;


import com.joao.takayama.API.entity.Proposta;

import java.util.List;

public interface IProposta {


    void excluir(String id);

    void salvar(Proposta proposta);

    List<Proposta> buscarPropostas();

    List<Proposta> buscarPropostasNotas();

    List<Proposta> buscarPropostasPrecos();
}
