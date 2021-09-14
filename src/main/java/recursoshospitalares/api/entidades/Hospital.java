package recursoshospitalares.api.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {
	
	@Id
	private Long cnpj;
	
	private String nome;
	private String endereco;
	private String localizacao;	
	
	private int medico;
	private int enfermeiro;
	private int respirador;
	private int tomografo;
	private int ambulancia;
	private Double taxaOcupacao;
	
	
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getMedico() {
		return medico;
	}
	public void setMedico(int medico) {
		this.medico = medico;
	}
	public int getEnfermeiro() {
		return enfermeiro;
	}
	public void setEnfermeiro(int enfermeiro) {
		this.enfermeiro = enfermeiro;
	}
	public int getRespirador() {
		return respirador;
	}
	public void setRespirador(int respirador) {
		this.respirador = respirador;
	}
	public int getTomografo() {
		return tomografo;
	}
	public void setTomografo(int tomografo) {
		this.tomografo = tomografo;
	}
	public int getAmbulancia() {
		return ambulancia;
	}
	public void setAmbulancia(int ambulancia) {
		this.ambulancia = ambulancia;
	}
	public Double getTaxaOcupacao() {
		return taxaOcupacao;
	}
	public void setTaxaOcupacao(Double taxaOcupacao) {
		this.taxaOcupacao = taxaOcupacao;
	}
	
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
