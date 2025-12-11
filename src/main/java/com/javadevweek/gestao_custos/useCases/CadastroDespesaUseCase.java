package com.javadevweek.gestao_custos.useCases;

import com.javadevweek.gestao_custos.entity.Despesa;

public class CadastroDespesaUseCase {
    //SOOLID
    //Single Responsibility Principle

    public void execute(Despesa despesa) {
        System.out.println(despesa);
    }
}
