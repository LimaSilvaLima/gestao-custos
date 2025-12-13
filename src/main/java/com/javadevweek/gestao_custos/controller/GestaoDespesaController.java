package com.javadevweek.gestao_custos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadevweek.gestao_custos.custom_messages.ErrorMessage;
import com.javadevweek.gestao_custos.entity.Despesa;
import com.javadevweek.gestao_custos.useCases.CadastroDespesaUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {
    
    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa) {
         
        try {
            var result = cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            var errorMessage = new ErrorMessage(e.getMessage(), "INVALID_PARAMS");
            return ResponseEntity.badRequest().body(errorMessage);
        }
               
    }

    @GetMapping("/{email}")
    public void findbyEmailAndData(@PathVariable String email, @RequestParam(required = false) LocalDate data) {
        System.out.println("Email :"  + email);
        System.out.println("Data :"  + data);
    }

}
