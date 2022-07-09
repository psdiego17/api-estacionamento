package controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EstacionamentoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String numeroVaga;
	private String placaCarro;
	private String marcaCarro;
	private String modeloCarro;
	private String corCarro;
	private LocalDateTime dataRegistro;
	private String nomePropietario;
	private String apartamentoPropietario;
	private String blocoPropietario;
	
	
	public EstacionamentoModel() {
		super();
	}
	
	public EstacionamentoModel(UUID id, String numeroVaga, String placaCarro, String marcaCarro, String modeloCarro,
			String corCarro, LocalDateTime dataRegistro, String nomePropietario, String apartamentoPropietario,
			String blocoPropietario) {
		super();
		this.id = id;
		this.numeroVaga = numeroVaga;
		this.placaCarro = placaCarro;
		this.marcaCarro = marcaCarro;
		this.modeloCarro = modeloCarro;
		this.corCarro = corCarro;
		this.dataRegistro = dataRegistro;
		this.nomePropietario = nomePropietario;
		this.apartamentoPropietario = apartamentoPropietario;
		this.blocoPropietario = blocoPropietario;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
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
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
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

	@Override
	public String toString() {
		return "EstacionamentoModel [id=" + id + ", numeroVaga=" + numeroVaga + ", placaCarro=" + placaCarro
				+ ", marcaCarro=" + marcaCarro + ", modeloCarro=" + modeloCarro + ", corCarro=" + corCarro
				+ ", dataRegistro=" + dataRegistro + ", nomePropietario=" + nomePropietario
				+ ", apartamentoPropietario=" + apartamentoPropietario + ", blocoPropietario=" + blocoPropietario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstacionamentoModel other = (EstacionamentoModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
