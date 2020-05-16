package com.joao.takayama.API.propostas;


import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.usecase.BuscarPropostas;
import com.joao.takayama.API.usecase.SalvarProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PropostasIpml implements IProposta{

    @Autowired
    private BuscarPropostas buscarPropostas;

    @Autowired
    private SalvarProposta salvarProposta;

    @Override
    public void salvar(Proposta proposta) {
        salvarProposta.execute(proposta);
    }

    @Override
    public List<Proposta> buscarPropostas() {
        return buscarPropostas.execute();
    }
}
