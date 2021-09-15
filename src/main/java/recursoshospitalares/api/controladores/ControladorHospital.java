package recursoshospitalares.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import recursoshospitalares.api.dtos.HospitalOcupacaoDto;
import recursoshospitalares.api.dtos.PorcentagemDto;
import recursoshospitalares.api.dtos.RecursosPorHospitalDto;
import recursoshospitalares.api.entidades.Hospital;
import recursoshospitalares.api.servicos.ServicosHospital;

@RestController
public class ControladorHospital {
	
	@Autowired
	private ServicosHospital servicoHospital;
	
	
	
	@PostMapping("v1/api/hospital")
	public ResponseEntity<Hospital> adicionaHospital(@RequestBody Hospital hospital){
		return new ResponseEntity<Hospital>(servicoHospital.adicionaHospital(hospital), HttpStatus.CREATED);
	}
	
	

	@PatchMapping("v1/api/hospital/{cnpj}")
    public ResponseEntity<HospitalOcupacaoDto> atualizaOcupacao(@PathVariable long cnpj, 
    		@RequestBody HospitalOcupacaoDto hospitalDto){		
		try {
            return new ResponseEntity<>(servicoHospital.atualizaTaxaOcupacao(cnpj, hospitalDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@GetMapping("v1/api/hospital/porcentagemMaior90")
	public ResponseEntity<PorcentagemDto> porcentagemMaior90(){
		return new ResponseEntity<PorcentagemDto>(servicoHospital.hospitalMaior90(), HttpStatus.OK);
	}
	
	@GetMapping("v1/api/hospital/porcentagemMenor90")
	public ResponseEntity<PorcentagemDto> porcentagemMenor90(){
		return new ResponseEntity<PorcentagemDto>(servicoHospital.hospitalMenor90(), HttpStatus.OK);
	}
	
	
	@GetMapping("v1/api/hospital/recursoshospitais")
	public ResponseEntity<RecursosPorHospitalDto> recursosHospitais(){
		return new ResponseEntity<RecursosPorHospitalDto>(servicoHospital.recursosHospitais(), HttpStatus.OK);
	}
	



	public ControladorHospital(ServicosHospital servicoHospital) {
		super();
		this.servicoHospital = servicoHospital;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
