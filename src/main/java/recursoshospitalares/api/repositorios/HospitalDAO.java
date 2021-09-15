package recursoshospitalares.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import recursoshospitalares.api.entidades.Hospital;
@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Long>{
	
	
	@Query(value = "SELECT * FROM HOSPITAL h WHERE h.TAXA_OCUPACAO > 90",
			nativeQuery = true)
	List<Hospital> findAllHospitalGreaterthan90();
	
	@Query(value = "SELECT * FROM HOSPITAL h WHERE h.TAXA_OCUPACAO < 90",
			nativeQuery = true)
	List<Hospital> findAllHospitalLessthan90();
	
	@Query(value = "SELECT SUM(MEDICO) FROM HOSPITAL",
			nativeQuery = true)
	int findAllMedico();
	
	@Query(value = "SELECT SUM(ENFERMEIRO) FROM HOSPITAL",
			nativeQuery = true)
	int findAllEnfermeiro();
	
	@Query(value = "SELECT SUM(RESPIRADOR) FROM HOSPITAL",
			nativeQuery = true)
	int findAllRespirador();
	
	@Query(value = "SELECT SUM(AMBULANCIA) FROM HOSPITAL",
			nativeQuery = true)
	int findAllAmbulancia();
	
	@Query(value = "SELECT SUM(TOMOGRAFO) FROM HOSPITAL",
			nativeQuery = true)
	int findAllTomografo();

}
