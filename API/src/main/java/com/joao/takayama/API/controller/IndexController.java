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

    @DeleteMapping("/proposta/{id}")
    private void excluiProposta(@PathVariable("id") String id){
        iProposta.excluir(id);
    }

    @GetMapping("/propostas")
    private List<Proposta> propostas(){
       return iProposta.buscarPropostas();
    }

    @GetMapping("/propostas/notas")
    private List<Proposta> propostasNota(){
        return iProposta.buscarPropostasNotas();
    }

    @PostMapping("/proposta")
    private void salvarProposta(@RequestBody Proposta proposta){
        iProposta.salvar(proposta);
    }

    @PutMapping("/proposta")
    private void editarProposta(@RequestBody Proposta proposta){
        iProposta.salvar(proposta);
    }


}
