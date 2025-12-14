package com.javadevweek.gestao_custos.performance;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javadevweek.gestao_custos.entity.Despesa;
import com.javadevweek.gestao_custos.repository.DespesaRepository;

@RequestMapping("/gestao/performance")
public class GestaoDespesaPerformance {

    @Autowired
    DespesaRepository despesaRepository;

    public ResponseEntity<List<Despesa>>listarSemPaginacao() {
        var despesas = despesaRepository.findAll();
        return ResponseEntity.ok(despesas);
    }
}
