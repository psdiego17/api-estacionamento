package com.br.api.estacionamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.estacionamento.model.EstacionamentoModel;
import com.br.api.estacionamento.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	
	final EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
		this.estacionamentoRepository = estacionamentoRepository;
	}

	
	//Buscar todos no banco de dados
	public List<EstacionamentoModel> buscarTodosService(){
		return estacionamentoRepository.findAll();
	}
}