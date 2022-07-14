package com.br.api.estacionamento.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.api.estacionamento.model.EstacionamentoModel;

@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoModel, UUID>{

}
