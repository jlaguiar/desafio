package com.joao.takayama.API.controller;

import com.joao.takayama.API.entity.Proposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/propostas")
    private void propostas(){
        List<Proposta> propostas;

    }
}
