package com.joao.takayama.API.propostas;


import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropostasIpml implements IProposta {

    @Autowired
    private BuscarPropostas buscarPropostas;

    @Autowired
    private BuscarPropostasNotas buscarPropostasNotas;

    @Autowired
    private BuscarPropostasPrecos buscarPropostasPrecos;

    @Autowired
    private SalvarProposta salvarProposta;

    @Autowired
    private ExcluirProposta excluirProposta;

    @Override
    public void excluir(String id) {
        excluirProposta.execute(id);
    }

    @Override
    public void salvar(Proposta proposta) {
        salvarProposta.execute(proposta);
    }

    @Override
    public List<Proposta> buscarPropostas() {
        return buscarPropostas.execute();
    }

    @Override
    public List<Proposta> buscarPropostasNotas() {
        return buscarPropostasNotas.execute();
    }

    @Override
    public List<Proposta> buscarPropostasPrecos() {
        return buscarPropostasPrecos.execute();
    }
}
