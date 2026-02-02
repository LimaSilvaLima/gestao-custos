package com.javadevweek.gestao_custos.useCases;

import org.springframework.stereotype.Service;
import com.javadevweek.gestao_custos.entity.Despesa;
import com.javadevweek.gestao_custos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CadastroDespesaUseCase {
    //SOOLID
    //Single Responsibility Principle
    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa execute(Despesa despesa) {
        
        if (despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null || despesa.getEmail() == null || despesa.getValor() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        despesaRepository.save(despesa);
        return despesa;

        /*System.out.println(despesa.getDescricao());
        System.out.println(despesa.getValor());.+
        System.out.println(despesa.getData());
        System.out.println(despesa.getCategoria());
        System.out.println(despesa.getEmail());
        System.out.println(despesa.getData_criacao());*/  
    }
}
