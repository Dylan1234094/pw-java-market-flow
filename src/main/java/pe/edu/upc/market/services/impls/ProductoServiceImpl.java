package pe.edu.upc.market.services.impls;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.market.models.entities.Producto;
import pe.edu.upc.market.models.repositories.ProductoRepository;
import pe.edu.upc.market.services.ProductoService;

@Named
public class ProductoServiceImpl implements ProductoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoRepository productoRepository;
	
	@Transactional
	@Override
	public Producto save(Producto entity) throws Exception {
		return productoRepository.save(entity);
	}

	@Transactional
	@Override
	public Producto update(Producto entity) throws Exception {
		return productoRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		productoRepository.deleteById(id);
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findAll() throws Exception {
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> findByNombre(String nombre) throws Exception {
		return productoRepository.findByNombre(nombre);
	}

}
