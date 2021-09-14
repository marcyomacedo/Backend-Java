package recursoshospitalares.api.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import recursoshospitalares.api.dtos.HospitalOcupacaoDto;
import recursoshospitalares.api.entidades.Hospital;
import recursoshospitalares.api.repositorios.HospitalDAO;

@Service
public class ServicosHospital {
	
	@Autowired
	private HospitalDAO repositorioHospital;

	
	public Hospital adicionaHospital(Hospital hospital) {
		
		if(hospital.getTaxaOcupacao() > 100 || hospital.getTaxaOcupacao() < 0) {
			
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
			
		}
		
		repositorioHospital.save(hospital);
		
		return hospital;
		
		
	}
	
	
	public Hospital atualizaTaxaOcupacao(Long cnpj, HospitalOcupacaoDto hospitalDto) {
		
		//Verificando se a taxa de ocupação é válida
		if(hospitalDto.getTaxaOcupacao() > 100 || hospitalDto.getTaxaOcupacao() < 0) {
			
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
			
		}		
		
		Hospital hospital = repositorioHospital.getById(cnpj);
		hospital.setTaxaOcupacao(hospitalDto.getTaxaOcupacao());
		
		repositorioHospital.save(hospital);
		
		return hospital;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServicosHospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
