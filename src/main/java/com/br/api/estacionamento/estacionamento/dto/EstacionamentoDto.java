package com.br.api.estacionamento.estacionamento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EstacionamentoDto {
	
	@NotBlank
	private String numeroVaga;
	
	@NotBlank
	@Size(max=7)
	private String placaCarro;
	
	@NotBlank
	private String marcaCarro;
	
	@NotBlank
	private String modeloCarro;
	
	@NotBlank
	private String corCarro;
	
	@NotBlank
	private String nomePropietario;
	
	@NotBlank
	private String apartamentoPropietario;
	
	@NotBlank
	private String blocoPropietario;
	
	
	public String getNumeroVaga() {
		return numeroVaga;
	}
	public void setNumeroVaga(String numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	public String getMarcaCarro() {
		return marcaCarro;
	}
	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public String getCorCarro() {
		return corCarro;
	}
	public void setCorCarro(String corCarro) {
		this.corCarro = corCarro;
	}
	public String getNomePropietario() {
		return nomePropietario;
	}
	public void setNomePropietario(String nomePropietario) {
		this.nomePropietario = nomePropietario;
	}
	public String getApartamentoPropietario() {
		return apartamentoPropietario;
	}
	public void setApartamentoPropietario(String apartamentoPropietario) {
		this.apartamentoPropietario = apartamentoPropietario;
	}
	public String getBlocoPropietario() {
		return blocoPropietario;
	}
	public void setBlocoPropietario(String blocoPropietario) {
		this.blocoPropietario = blocoPropietario;
	}
	
	
}
