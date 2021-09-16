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
		
		//Verificando se a Taxa de ocupação é válida
		if(hospital.getTaxaOcupacao() > 100 || hospital.getTaxaOcupacao() < 0) {
			
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
			
		}
		
		//Salvando no banco após a confirmação da taxa
		repositorioHospital.save(hospital);
		
		return hospital;	
		
	}
	
	
	public HospitalOcupacaoDto atualizaTaxaOcupacao(Long cnpj, HospitalOcupacaoDto hospitalDto) {
		
		//Verificando se a taxa de ocupação é válida
		if(hospitalDto.getTaxaOcupacao() <= 100 && hospitalDto.getTaxaOcupacao() >= 0) {
			
			//Recuperando o hospital pelo cnpj
			Hospital hospital = repositorioHospital.getById(cnpj);
			
			//Atualizando a taxa de ocupação
			hospital.setTaxaOcupacao(hospitalDto.getTaxaOcupacao());
			
			//Salvando o hospital com a taxa atualizada
			repositorioHospital.save(hospital);
			
			return hospitalDto;
			
		}			
		
		
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
		
		
		
		
		
		
	}
	
	public PorcentagemDto hospitalMaior90() {
		
		//Recuperando a quantidade de hospitais com taxa de ocupação maior que 90
		double maior90 = repositorioHospital.findAllHospitalGreaterthan90().size();
		
		//Recuperando o número total de hospitais
		double hospitais = repositorioHospital.findAll().size();
		
		//Fazendo o cálculo da porcentagem
		double porcentagemMaior90 = maior90 / hospitais * 100;
		
		//Criando o objeto que retornará o valor da porcentagem
		PorcentagemDto p = new PorcentagemDto();
		
		//Setando o valor
		p.setPorcentagem(porcentagemMaior90);
		
		return p;
	}
		
		
	public PorcentagemDto hospitalMenor90() {
		
		//Recuperando a quantidade de hospitais com taxa de ocupação menor que 90
		double menor90 = repositorioHospital.findAllHospitalLessthan90().size();
		
		//Recuperando o número total de hospitais
		double hospitais = repositorioHospital.findAll().size();
		
		//Fazendo o cálculo da porcentagem
		double porcentagemMaior90 = menor90 / hospitais * 100;
		
		//Criando o objeto que retornará o valor da porcentagem
		PorcentagemDto p = new PorcentagemDto();
		
		//Setando o valor
		p.setPorcentagem(porcentagemMaior90);
			
		return p;
		

		
		
		
	}
	
	public RecursosPorHospitalDto recursosHospitais() {
		
		//Recuperando o número total de hospitais
		int nHospitais = repositorioHospital.findAll().size();
		
		//Recuperando o número total de recursos e dividindo pelo número total de hospitais
		int mediaMedicos = repositorioHospital.findAllMedico() / nHospitais;
		int mediaEnfermeiros = repositorioHospital.findAllEnfermeiro() / nHospitais;
		int mediaAmbulancias = repositorioHospital.findAllAmbulancia() / nHospitais;
		int mediaRespiradores = repositorioHospital.findAllRespirador() / nHospitais;
		int mediaTomografos = repositorioHospital.findAllTomografo() / nHospitais;
		
		//Criando o objeto que irá retornar as médias
		RecursosPorHospitalDto r = new RecursosPorHospitalDto();
		
		//Setando os valores
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
