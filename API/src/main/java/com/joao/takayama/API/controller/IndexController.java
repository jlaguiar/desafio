package com.joao.takayama.API.controller;

import com.joao.takayama.API.entity.Proposta;
import com.joao.takayama.API.propostas.IProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IProposta iProposta;

    @GetMapping("/propostas")
    private List<Proposta> propostas(){
       return iProposta.buscarPropostas();
    }

    @PostMapping("/proposta")
    private void salvarProposta(@RequestBody Proposta proposta){
        iProposta.salvar(proposta);
    }
}
