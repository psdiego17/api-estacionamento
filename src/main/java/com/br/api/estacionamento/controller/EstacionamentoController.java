package com.br.api.estacionamento.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.estacionamento.model.EstacionamentoModel;
import com.br.api.estacionamento.services.EstacionamentoService;



@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	//Forma de criar injeção depedência, precisa criar o contrutor.
	final EstacionamentoService estacionamentoService;
	
	@Autowired
	public EstacionamentoController(EstacionamentoService estacionamentoService) {
		this.estacionamentoService = estacionamentoService;
	}

	
	@GetMapping("/todos")
	public ResponseEntity<List<EstacionamentoModel>> buscarTodosController(){
		
		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.buscarTodosService());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPeloIdController(@PathVariable(value = "id") UUID id){
		
		Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.buscarPeloIdService(id);
		
		if(!estacionamentoModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga Não localizada!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoModelOptional.get());
	}
}

