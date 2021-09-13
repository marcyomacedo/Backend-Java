package recursoshospitalares.api.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "intercambio")
public class Intercambio {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idLong;
	
	//Dados do primeiro hospital	
	private Long cnpjHospital1;
	private int medico1;
	private int enfermeiro1;
	private int respirador1;
	private int tomografo1;
	private int ambulancia1;
	
	//Dados do segundo hospital
	private Long cnpjHospital2;
	private int medico2;
	private int enfermeiro2;
	private int respirador2;
	private int tomografo2;
	private int ambulancia2;
	
	
	
	
	public Long getIdLong() {
		return idLong;
	}
	public Long getCnpjHospital1() {
		return cnpjHospital1;
	}
	public void setCnpjHospital1(Long cnpjHospital1) {
		this.cnpjHospital1 = cnpjHospital1;
	}
	public int getMedico1() {
		return medico1;
	}
	public void setMedico1(int medico1) {
		this.medico1 = medico1;
	}
	public int getEnfermeiro1() {
		return enfermeiro1;
	}
	public void setEnfermeiro1(int enfermeiro1) {
		this.enfermeiro1 = enfermeiro1;
	}
	public int getRespirador1() {
		return respirador1;
	}
	public void setRespirador1(int respirador1) {
		this.respirador1 = respirador1;
	}
	public int getTomografo1() {
		return tomografo1;
	}
	public void setTomografo1(int tomografo1) {
		this.tomografo1 = tomografo1;
	}
	public int getAmbulancia1() {
		return ambulancia1;
	}
	public void setAmbulancia1(int ambulancia1) {
		this.ambulancia1 = ambulancia1;
	}
	public Long getCnpjHospital2() {
		return cnpjHospital2;
	}
	public void setCnpjHospital2(Long cnpjHospital2) {
		this.cnpjHospital2 = cnpjHospital2;
	}
	public int getMedico2() {
		return medico2;
	}
	public void setMedico2(int medico2) {
		this.medico2 = medico2;
	}
	public int getEnfermeiro2() {
		return enfermeiro2;
	}
	public void setEnfermeiro2(int enfermeiro2) {
		this.enfermeiro2 = enfermeiro2;
	}
	public int getRespirador2() {
		return respirador2;
	}
	public void setRespirador2(int respirador2) {
		this.respirador2 = respirador2;
	}
	public int getTomografo2() {
		return tomografo2;
	}
	public void setTomografo2(int tomografo2) {
		this.tomografo2 = tomografo2;
	}
	public int getAmbulancia2() {
		return ambulancia2;
	}
	public void setAmbulancia2(int ambulancia2) {
		this.ambulancia2 = ambulancia2;
	}
	public Intercambio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	

}
