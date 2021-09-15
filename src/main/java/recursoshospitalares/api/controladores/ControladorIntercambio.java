package recursoshospitalares.api.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import recursoshospitalares.api.dtos.IntercambioDto;
import recursoshospitalares.api.entidades.Intercambio;
import recursoshospitalares.api.servicos.ServicosIntercambio;

@RestController
public class ControladorIntercambio {
	
	@Autowired
	private ServicosIntercambio servicoIntercambio;
	
	
	
	
	@PostMapping("v1/api/intercambio")
	public ResponseEntity<Intercambio> adicionaHospital(@RequestBody IntercambioDto intercambio){
		
		try {
			return new ResponseEntity<Intercambio>(this.servicoIntercambio.realizaIntercambio(intercambio), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
		
		
	}
	
	@GetMapping("v1/api/intercambio/historico")
	public ResponseEntity<List<Intercambio>> historico(){
		return new ResponseEntity<List<Intercambio>>(servicoIntercambio.historico(), HttpStatus.OK);
	}
	
	
	
	
	

	public ControladorIntercambio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
