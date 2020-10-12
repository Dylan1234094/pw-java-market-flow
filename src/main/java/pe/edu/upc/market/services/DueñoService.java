package pe.edu.upc.market.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.market.models.entities.Dueño;

public interface DueñoService extends CrudService<Dueño, Integer> {
	List<Dueño> findByNombre(String nombre) throws Exception; //devuelve varios valores
	Optional<Dueño> findByNumeroDocumento(String numeroDocumento) throws Exception; //devuelve solo un valor
}

