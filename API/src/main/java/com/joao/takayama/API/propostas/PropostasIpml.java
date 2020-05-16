package com.joao.takayama.API.propostas;


import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.usecase.BuscarPropostas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PropostasIpml implements IProposta{

    @Autowired
    private BuscarPropostas buscarPropostas;

    @Override
    public List<Proposta> buscarPropostas() {
        return buscarPropostas.execute();
    }
}
