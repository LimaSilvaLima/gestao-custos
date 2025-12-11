package com.javadevweek.gestao_custos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadevweek.gestao_custos.entity.Despesa;
import com.javadevweek.gestao_custos.useCases.CadastroDespesaUseCase;

@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {

    @PostMapping("/create")
    public void create(Despesa despesa) {
        CadastroDespesaUseCase cadastroDespesaUseCase = new CadastroDespesaUseCase(); 
        cadastroDespesaUseCase.execute(despesa);      
    }
}
