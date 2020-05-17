package com.joao.takayama.API.usecase;

import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SalvarProposta {

    @Autowired
    private PropostaRepository propostaRepository;

    public void execute(Proposta proposta){
        preencherDataAtual(proposta);
        propostaRepository.save(proposta);
    }

    public void preencherDataAtual(Proposta proposta){
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        proposta.setDataCadastro(dataAtual.format(formatarData));
    }
}
