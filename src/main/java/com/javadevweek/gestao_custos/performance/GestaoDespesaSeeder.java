package com.javadevweek.gestao_custos.performance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.javadevweek.gestao_custos.entity.Despesa;
import com.javadevweek.gestao_custos.repository.DespesaRepository;

//@Component
public class GestaoDespesaSeeder implements CommandLineRunner{

    @Autowired
    private DespesaRepository despesaRepository;
 
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicação iniciada com sucesso!");
        List<Despesa> despesas = new ArrayList<>();
        
         
        for (int i = 0; i < 100; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Despesa de teste " + i);
            despesa.setData(java.time.LocalDate.now());
            despesa.setValor(BigDecimal.valueOf(100.0 + (i % 10) * 10)); // Valores entre 100 e 190
            despesa.setCategoria("Categoria " + (i % 3));
            despesa.setEmail("recalculus@recalculus.com.br"); // 5 usuários diferentes
            //despesa.setEmail("usuario" + (i % 5) + "@exemplo.com"); // 5 usuários diferentes
            despesa.setData_criacao(java.time.LocalDate.now().minusDays(i %30)); //(1 a 30 dias atrás)
            
            despesas.add(despesa);
            
            //despesaRepository.save(despesa);
            //System.out.println("Contagem de despesas realizada: " + (i + 1) + "/150000");

        }
         despesaRepository.saveAll(despesas);
         System .out.println("Finalizou geração do seed " );
    }

}          
