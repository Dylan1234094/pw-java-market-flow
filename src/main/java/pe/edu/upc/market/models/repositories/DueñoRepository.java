package pe.edu.upc.market.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.market.models.entities.Due�o;

public interface Due�oRepository extends JpaRepository<Due�o, Integer> {
	List<Due�o> findByNombre(String nombre) throws Exception; //devuelve varios valores
	Optional<Due�o> findByNumeroDocumento(String numeroDocumento) throws Exception; //devuelve solo un valor
}
