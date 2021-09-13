package recursoshospitalares.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recursoshospitalares.api.entidades.Hospital;
@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Long>{

}
