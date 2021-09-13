package recursoshospitalares.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recursoshospitalares.api.entidades.Intercambio;
@Repository
public interface IntercambioDAO extends JpaRepository<Intercambio, Long>{

}
