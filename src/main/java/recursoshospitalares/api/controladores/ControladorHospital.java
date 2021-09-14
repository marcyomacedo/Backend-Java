package recursoshospitalares.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import recursoshospitalares.api.dtos.HospitalOcupacaoDto;
import recursoshospitalares.api.entidades.Hospital;
import recursoshospitalares.api.servicos.ServicosHospital;

@RestController
public class ControladorHospital {
	
	@Autowired
	private ServicosHospital servicoHospital;
	
	
	
	@PostMapping("v1/api/hospital")
	public ResponseEntity<Hospital> adicionaHospital(@RequestBody Hospital hospital){
		return new ResponseEntity<Hospital>(this.servicoHospital.adicionaHospital(hospital), HttpStatus.CREATED);
	}
	
	@PatchMapping("v1/api/hospital/{id}")
    public ResponseEntity<Hospital> atualizaOcupacao(@PathVariable Long id,
    		@RequestBody HospitalOcupacaoDto hospitalDto){
		
		try {
            return new ResponseEntity<Hospital>(this.servicoHospital.atualizaTaxaOcupacao(id, hospitalDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ControladorHospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
