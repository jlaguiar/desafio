package com.joao.takayama.API.usecase;

import com.joao.takayama.API.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExcluirProposta {

    @Autowired
    private PropostaRepository propostaRepository;

    public void execute(String id){
        propostaRepository.deleteById(id);
    }
}
