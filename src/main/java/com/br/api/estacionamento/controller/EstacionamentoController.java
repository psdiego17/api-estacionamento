package com.br.api.estacionamento.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.api.estacionamento.estacionamento.dto.EstacionamentoDto;
import com.br.api.estacionamento.model.EstacionamentoModel;
import com.br.api.estacionamento.services.EstacionamentoService;

@RestController
@RequestMapping("/api")
public class EstacionamentoController {

	// Forma de criar injeção depedência, precisa criar o contrutor.
	final EstacionamentoService estacionamentoService;

	public EstacionamentoController(EstacionamentoService estacionamentoService) {
		this.estacionamentoService = estacionamentoService;
	}

	// Buscar todos os contatos
	@GetMapping("/vagas-em-uso")
	public ResponseEntity<List<EstacionamentoModel>> buscarTodosController() {

		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.buscarTodosService());
	}
	
	
	// Buscar um contato pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPeloIdController(@PathVariable(value = "id") UUID id) {

		Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.buscarPeloIdService(id);

		if (!estacionamentoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga Não localizada!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoModelOptional.get());
	}

	// Buscar um contato pelo nome
	@GetMapping("/nome/{nomePropietario}")
	public ResponseEntity<Object> buscarPeloNomeController(
			@PathVariable(value = "nomePropietario") String nomePropietario) {

		Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService
				.buscarPeloNomeService(nomePropietario);

		if (!estacionamentoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Morador não localizado!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoModelOptional.get());
	}

	// Salvar um contato
	@PostMapping
	public ResponseEntity<Object> salvarController(@RequestBody @Valid EstacionamentoDto estacionamentoDto) {

		/*
		 * if (estacionamentoService.existsByPlaca(estacionamentoDto.getPlacaCarro())) {
		 * return ResponseEntity.status(HttpStatus.CONFLICT).
		 * body("Já existe um cadastro para essa placa"); }
		 * 
		 * if
		 * (estacionamentoService.existsByNumeroVaga(estacionamentoDto.getNumeroVaga()))
		 * { return ResponseEntity.status(HttpStatus.CONFLICT).
		 * body("Já existe um cadastro para essa vaga"); }
		 * 
		 * if (estacionamentoService.existsByApartamentBloco(estacionamentoDto.
		 * getApartamentoPropietario(), estacionamentoDto.getBlocoPropietario())) {
		 * return ResponseEntity.status(HttpStatus.CONFLICT).
		 * body("Já existe um cadastro para esse apartamento e bloco"); }
		 */

		var estacionamentoModel = new EstacionamentoModel();
		// Convertendo o dto para o model para salvar no banco
		BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
		estacionamentoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.salvarService(estacionamentoModel));
	}

	//Deletar um contato
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarController(@PathVariable(value = "id") UUID id) {
		Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);

		if (!estacionamentoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
		}

		estacionamentoService.deletarService(estacionamentoModelOptional.get());

		return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com sucesso");
	}
	
	//Atualizar um contato
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarController(@PathVariable(value = "id") UUID id, @RequestBody @Valid EstacionamentoDto estacionamentoDto){
		Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
		if(!estacionamentoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não localizado");
		}
		
		var estacionamentoModel = new EstacionamentoModel();
		BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
		
		//Aqui passa os dois parâmentros que não serão alterados
		estacionamentoModel.setId(estacionamentoModelOptional.get().getId());
		estacionamentoModel.setDataRegistro(estacionamentoModelOptional.get().getDataRegistro());
		
		//Pode-se também setar todos os dados que serão alterados ficaria assim
		//estacionamentoModel.setCorCarro(estacionamentoDto.getCorCarro());
		
		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.salvarService(estacionamentoModel));
	}

}
