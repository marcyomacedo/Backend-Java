package recursoshospitalares.api.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import recursoshospitalares.api.dtos.IntercambioDto;
import recursoshospitalares.api.entidades.Hospital;
import recursoshospitalares.api.entidades.Intercambio;
import recursoshospitalares.api.repositorios.HospitalDAO;
import recursoshospitalares.api.repositorios.IntercambioDAO;

@Service
public class ServicosIntercambio {
	
	@Autowired
	private IntercambioDAO repositorioIntercambio;
	@Autowired
	private HospitalDAO repositorioHospital;
	
	
	
	
	public Intercambio realizaIntercambio(IntercambioDto intercambioDto) {
		
		Hospital hospital1 = repositorioHospital.getById(intercambioDto.getCnpjHospital1());
		Hospital hospital2 = repositorioHospital.getById(intercambioDto.getCnpjHospital2());
		
		Intercambio intercambio = new Intercambio();
		
		int pontosHospital1 = intercambioDto.getAmbulancia1()*10 + intercambioDto.getMedico1()*3 + intercambioDto.getEnfermeiro1()*3
				+ intercambioDto.getRespirador1()*5 + intercambioDto.getTomografo1()*12;
		
		int pontosHospital2 = intercambioDto.getAmbulancia2()*10 + intercambioDto.getMedico2()*3 + intercambioDto.getEnfermeiro2()*3
				+ intercambioDto.getRespirador2()*5 + intercambioDto.getTomografo2()*12;
		
		if(pontosHospital1 == pontosHospital2) {
			
			//Realizando a soma de recursos do hospital 1
			hospital1.setAmbulancia(hospital1.getAmbulancia() + intercambioDto.getAmbulancia2());
			hospital1.setMedico(hospital1.getMedico() + intercambioDto.getMedico2());
			hospital1.setEnfermeiro(hospital1.getEnfermeiro() + intercambioDto.getEnfermeiro2());
			hospital1.setRespirador(hospital1.getRespirador() + intercambioDto.getRespirador2());
			hospital1.setTomografo(hospital1.getTomografo() + intercambioDto.getTomografo2());
			
			//Realizando a soma de recursos do hospital 2
			hospital2.setAmbulancia(hospital2.getAmbulancia() + intercambioDto.getAmbulancia1());
			hospital2.setMedico(hospital2.getMedico() + intercambioDto.getMedico1());
			hospital2.setEnfermeiro(hospital2.getEnfermeiro() + intercambioDto.getEnfermeiro1());
			hospital2.setRespirador(hospital2.getRespirador() + intercambioDto.getRespirador1());
			hospital2.setTomografo(hospital2.getTomografo() + intercambioDto.getTomografo1());
			
			//Preenchendo o objeto Intercambio
			intercambio.setCnpjHospital1(intercambioDto.getCnpjHospital1());
			intercambio.setCnpjHospital2(intercambioDto.getCnpjHospital2());
			intercambio.setAmbulancia1(intercambioDto.getAmbulancia1());
			intercambio.setAmbulancia2(intercambioDto.getAmbulancia2());
			intercambio.setMedico1(intercambioDto.getMedico1());
			intercambio.setMedico2(intercambioDto.getMedico2());
			intercambio.setEnfermeiro1(intercambioDto.getEnfermeiro1());
			intercambio.setEnfermeiro2(intercambioDto.getEnfermeiro2());
			intercambio.setRespirador1(intercambioDto.getRespirador1());
			intercambio.setRespirador2(intercambioDto.getRespirador2());
			intercambio.setTomografo1(intercambioDto.getTomografo1());
			intercambio.setTomografo2(intercambioDto.getTomografo2());
			
			//Salvando no banco de dados
			repositorioHospital.save(hospital1);
			repositorioHospital.save(hospital2);
			repositorioIntercambio.save(intercambio);
			
			//Retornando a operação
			return intercambio;
			
		}else if(hospital1.getTaxaOcupacao() > 90 || hospital2.getTaxaOcupacao() > 90) {			

			//Realizando a soma de recursos do hospital 1
			hospital1.setAmbulancia(hospital1.getAmbulancia() + intercambioDto.getAmbulancia2());
			hospital1.setMedico(hospital1.getMedico() + intercambioDto.getMedico2());
			hospital1.setEnfermeiro(hospital1.getEnfermeiro() + intercambioDto.getEnfermeiro2());
			hospital1.setRespirador(hospital1.getRespirador() + intercambioDto.getRespirador2());
			hospital1.setTomografo(hospital1.getTomografo() + intercambioDto.getTomografo2());
			
			//Realizando a soma de recursos do hospital 2
			hospital2.setAmbulancia(hospital2.getAmbulancia() + intercambioDto.getAmbulancia1());
			hospital2.setMedico(hospital2.getMedico() + intercambioDto.getMedico1());
			hospital2.setEnfermeiro(hospital2.getEnfermeiro() + intercambioDto.getEnfermeiro1());
			hospital2.setRespirador(hospital2.getRespirador() + intercambioDto.getRespirador1());
			hospital2.setTomografo(hospital2.getTomografo() + intercambioDto.getTomografo1());
			
			//Preenchendo o objeto Intercambio
			intercambio.setCnpjHospital1(intercambioDto.getCnpjHospital1());
			intercambio.setCnpjHospital2(intercambioDto.getCnpjHospital2());
			intercambio.setAmbulancia1(intercambioDto.getAmbulancia1());
			intercambio.setAmbulancia2(intercambioDto.getAmbulancia2());
			intercambio.setMedico1(intercambioDto.getMedico1());
			intercambio.setMedico2(intercambioDto.getMedico2());
			intercambio.setEnfermeiro1(intercambioDto.getEnfermeiro1());
			intercambio.setEnfermeiro2(intercambioDto.getEnfermeiro2());
			intercambio.setRespirador1(intercambioDto.getRespirador1());
			intercambio.setRespirador2(intercambioDto.getRespirador2());
			intercambio.setTomografo1(intercambioDto.getTomografo1());
			intercambio.setTomografo2(intercambioDto.getTomografo2());
			
			//Salvando no banco de dados
			repositorioHospital.save(hospital1);
			repositorioHospital.save(hospital2);
			repositorioIntercambio.save(intercambio);
			
			//Retornando a operação
			return intercambio;
			
		}
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
	
		
		
		
	
		
		
		
			
			
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServicosIntercambio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
