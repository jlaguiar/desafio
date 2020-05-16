package com.joao.takayama.API.usecase;

import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BuscarPropostas {

    @Autowired
    private PropostaRepository propostaRepository;

    public List<Proposta> execute(){
        return propostaRepository.findAll();
    }
}
