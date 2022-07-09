package com.br.api.estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.Index;

@SpringBootApplication
public class EstacionamentoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
		
		
	}
	
	
}
