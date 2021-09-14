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
	
	
	public Hospital(Long cnpj, String nome, String endereco, String localizacao, int medico, int enfermeiro,
			int respirador, int tomografo, int ambulancia, Double taxaOcupacao) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.localizacao = localizacao;
		this.medico = medico;
		this.enfermeiro = enfermeiro;
		this.respirador = respirador;
		this.tomografo = tomografo;
		this.ambulancia = ambulancia;
		this.taxaOcupacao = taxaOcupacao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ambulancia;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + enfermeiro;
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + medico;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + respirador;
		result = prime * result + ((taxaOcupacao == null) ? 0 : taxaOcupacao.hashCode());
		result = prime * result + tomografo;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (ambulancia != other.ambulancia)
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (enfermeiro != other.enfermeiro)
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (medico != other.medico)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (respirador != other.respirador)
			return false;
		if (taxaOcupacao == null) {
			if (other.taxaOcupacao != null)
				return false;
		} else if (!taxaOcupacao.equals(other.taxaOcupacao))
			return false;
		if (tomografo != other.tomografo)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
