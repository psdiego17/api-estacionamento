package com.br.api.estacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	
	//Buscar um contato pelo ID
	public Optional<EstacionamentoModel> buscarPeloIdService(UUID id) {

		return estacionamentoRepository.findById(id);
	}
	
	public Optional<EstacionamentoModel> buscarPeloNomeService(String nomePropietario) {

		return Optional.ofNullable(estacionamentoRepository.findByNomePropietario(nomePropietario));
	}
	
}