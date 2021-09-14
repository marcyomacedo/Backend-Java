package recursoshospitalares.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import recursoshospitalares.api.entidades.Hospital;
@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Long>{
	
	
	@Query(value = "SELECT * FROM HOSPITAL h WHERE h.taxaOcupacao > 90",
			nativeQuery = true)
	List<Hospital> findAllHospitalGreaterthan90();

}
