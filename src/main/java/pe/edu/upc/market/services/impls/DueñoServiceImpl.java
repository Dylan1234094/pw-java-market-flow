package pe.edu.upc.market.services.impls;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.market.models.entities.Dueño;
import pe.edu.upc.market.models.repositories.DueñoRepository;
import pe.edu.upc.market.services.DueñoService;

@Named
public class DueñoServiceImpl implements DueñoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DueñoRepository dueñoRepository;
	
	@Transactional //Sentencia sql que altera la bd 
	@Override
	public Dueño save(Dueño entity) throws Exception {
		return dueñoRepository.save(entity);
	}

	@Transactional //Sentencia sql que altera la bd 
	@Override
	public Dueño update(Dueño entity) throws Exception {
		return dueñoRepository.update(entity);
	}

	@Transactional //Sentencia sql que altera la bd 
	@Override
	public void deleteById(Integer id) throws Exception {
		dueñoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Dueño> findById(Integer id) throws Exception {
		return dueñoRepository.findById(id);
	}

	@Override
	public List<Dueño> findAll() throws Exception {
		return dueñoRepository.findAll();
	}

	@Override
	public List<Dueño> findByNombre(String nombre) throws Exception {
		return dueñoRepository.findByNombre(nombre);
	}

	@Override
	public Optional<Dueño> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return dueñoRepository.findByNumeroDocumento(numeroDocumento);
	}

}
