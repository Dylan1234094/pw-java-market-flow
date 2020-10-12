package pe.edu.upc.market.services.impls;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.market.models.entities.Due�o;
import pe.edu.upc.market.models.repositories.Due�oRepository;
import pe.edu.upc.market.services.Due�oService;

@Named
public class Due�oServiceImpl implements Due�oService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Due�oRepository due�oRepository;
	
	@Transactional //Sentencia sql que altera la bd 
	@Override
	public Due�o save(Due�o entity) throws Exception {
		return due�oRepository.save(entity);
	}

	@Transactional //Sentencia sql que altera la bd 
	@Override
	public Due�o update(Due�o entity) throws Exception {
		return due�oRepository.update(entity);
	}

	@Transactional //Sentencia sql que altera la bd 
	@Override
	public void deleteById(Integer id) throws Exception {
		due�oRepository.deleteById(id);
		
	}

	@Override
	public Optional<Due�o> findById(Integer id) throws Exception {
		return due�oRepository.findById(id);
	}

	@Override
	public List<Due�o> findAll() throws Exception {
		return due�oRepository.findAll();
	}

	@Override
	public List<Due�o> findByNombre(String nombre) throws Exception {
		return due�oRepository.findByNombre(nombre);
	}

	@Override
	public Optional<Due�o> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return due�oRepository.findByNumeroDocumento(numeroDocumento);
	}

}
