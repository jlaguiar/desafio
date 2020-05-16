package com.joao.takayama.API.propostas;


import com.joao.takayama.API.entity.Proposta;

import java.util.List;

public interface IProposta {

    void salvar(Proposta proposta);

    List<Proposta> buscarPropostas();

}
