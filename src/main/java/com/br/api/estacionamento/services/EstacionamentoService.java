package com.br.api.estacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.br.api.estacionamento.model.EstacionamentoModel;
import com.br.api.estacionamento.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	final EstacionamentoRepository estacionamentoRepository;

	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
		this.estacionamentoRepository = estacionamentoRepository;

	}

	// Buscar todos no banco de dados
	public List<EstacionamentoModel> buscarTodosService() {
		return estacionamentoRepository.findAll();
	}

	// Buscar um contato pelo ID
	public Optional<EstacionamentoModel> buscarPeloIdService(UUID id) {

		return estacionamentoRepository.findById(id);
	}

	// Buscar um contato pelo nome
	public Optional<EstacionamentoModel> buscarPeloNomeService(String nomePropietario) {

		return Optional.ofNullable(estacionamentoRepository.findByNomePropietario(nomePropietario));
	}

	// Salvar um contato
	@Transactional
	public EstacionamentoModel salvarService(EstacionamentoModel estacionamentoModel) {

		return estacionamentoRepository.save(estacionamentoModel);
	}
	
	 
	/*
	 * public boolean existsByPlaca(String placaCarro) {
	 * 
	 * return estacionamentoRepository.existsByPlaca(placaCarro); }
	 * 
	 * public boolean existsByNumeroVaga(String numeroVaga) {
	 * 
	 * return estacionamentoRepository.existsByNumeroVaga(numeroVaga); }
	 * 
	 * public boolean existsByApartamentBloco(String apartamentoPropietario, String
	 * blocoPropietario) {
	 * 
	 * return
	 * estacionamentoRepository.existsByApartamentBloco(apartamentoPropietario,
	 * blocoPropietario); }
	 */
	

	// Deletar um contato
	@Transactional
	public void deletarService(EstacionamentoModel estacionamentoModel) {
		estacionamentoRepository.delete(estacionamentoModel);
	}

	public Optional<EstacionamentoModel> findById(UUID id) {
		return estacionamentoRepository.findById(id);
	}	
}