package com.joao.takayama.API.repository;

import com.joao.takayama.API.entity.Proposta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PropostaRepository extends MongoRepository<Proposta,String> {

    List<Proposta> findAllByNotaNotNull();

    List<Proposta> findAllByNotaNull();
}
