package com.javadevweek.gestao_custos.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javadevweek.gestao_custos.entity.Despesa;

public interface  DespesaRepository extends JpaRepository<Despesa, UUID> {

}
