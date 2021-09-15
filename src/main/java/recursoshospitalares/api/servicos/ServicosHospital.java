package recursoshospitalares.api.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import recursoshospitalares.api.dtos.HospitalOcupacaoDto;
import recursoshospitalares.api.dtos.PorcentagemDto;
import recursoshospitalares.api.dtos.RecursosPorHospitalDto;
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
	
	
	public HospitalOcupacaoDto atualizaTaxaOcupacao(Long cnpj, HospitalOcupacaoDto hospitalDto) {
		
		//Verificando se a taxa de ocupação é válida
		if(hospitalDto.getTaxaOcupacao() <= 100 && hospitalDto.getTaxaOcupacao() >= 0) {
			
			Hospital hospital = repositorioHospital.getById(cnpj);
			hospital.setTaxaOcupacao(hospitalDto.getTaxaOcupacao());
			
			repositorioHospital.save(hospital);
			
			return hospitalDto;
			
		}			
		
		
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
		
		
		
		
		
		
	}
	
	public PorcentagemDto hospitalMaior90() {
		
		double maior90 = repositorioHospital.findAllHospitalGreaterthan90().size();
		double hospitais = repositorioHospital.findAll().size();
		
		double porcentagemMaior90 = maior90 / hospitais * 100;
		
		PorcentagemDto p = new PorcentagemDto();
		p.setPorcentagem(porcentagemMaior90);
		
		return p;
	}
		
		
	public PorcentagemDto hospitalMenor90() {
			
		double menor90 = repositorioHospital.findAllHospitalLessthan90().size();
		double hospitais = repositorioHospital.findAll().size();
			
		double porcentagemMaior90 = menor90 / hospitais * 100;
			
		PorcentagemDto p = new PorcentagemDto();
		p.setPorcentagem(porcentagemMaior90);
			
		return p;
		

		
		
		
	}
	
	public RecursosPorHospitalDto recursosHospitais() {
		
		int nHospitais = repositorioHospital.findAll().size();
		
		int mediaMedicos = repositorioHospital.findAllMedico() / nHospitais;
		int mediaEnfermeiros = repositorioHospital.findAllEnfermeiro() / nHospitais;
		int mediaAmbulancias = repositorioHospital.findAllAmbulancia() / nHospitais;
		int mediaRespiradores = repositorioHospital.findAllRespirador() / nHospitais;
		int mediaTomografos = repositorioHospital.findAllTomografo() / nHospitais;
		
		RecursosPorHospitalDto r = new RecursosPorHospitalDto();
		
		r.setAmbulancias(mediaAmbulancias);
		r.setEnfermeiros(mediaEnfermeiros);
		r.setMedicos(mediaMedicos);
		r.setRespiradores(mediaRespiradores);
		r.setTomografos(mediaTomografos);
		
		return r;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServicosHospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
