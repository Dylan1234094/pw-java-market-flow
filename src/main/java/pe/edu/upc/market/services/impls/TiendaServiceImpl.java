package pe.edu.upc.market.services.impls;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.market.models.entities.Tienda;
import pe.edu.upc.market.models.repositories.TiendaRepository;
import pe.edu.upc.market.services.TiendaService;

public class TiendaServiceImpl implements TiendaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TiendaRepository tiendaRepository; 
	
	@Transactional
	@Override
	public Tienda save(Tienda entity) throws Exception {
		return tiendaRepository.save(entity);
	}

	@Transactional
	@Override
	public Tienda update(Tienda entity) throws Exception {
		return tiendaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tiendaRepository.deleteById(id);
	}

	@Override
	public Optional<Tienda> findById(Integer id) throws Exception {
		return tiendaRepository.findById(id);
	}

	@Override
	public List<Tienda> findAll() throws Exception {
		return tiendaRepository.findAll();
	}

	@Override
	public List<Tienda> findByNombre(String nombre) throws Exception {
		return tiendaRepository.findByNombre(nombre);
	}
	
}
