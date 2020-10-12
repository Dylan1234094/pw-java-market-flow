package pe.edu.upc.market.services.impls;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.market.models.entities.ProductoTienda;
import pe.edu.upc.market.models.repositories.ProductoTiendaRepository;
import pe.edu.upc.market.services.ProductoTiendaService;

public class ProductoTiendaServiceImpl implements ProductoTiendaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoTiendaRepository productoTiendaRepository;
	
	@Transactional
	@Override
	public ProductoTienda save(ProductoTienda entity) throws Exception {
		return productoTiendaRepository.update(entity);
	}

	@Transactional
	@Override
	public ProductoTienda update(ProductoTienda entity) throws Exception {
		return productoTiendaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		productoTiendaRepository.deleteById(id);
	}

	@Override
	public Optional<ProductoTienda> findById(Integer id) throws Exception {
		return productoTiendaRepository.findById(id);
	}

	@Override
	public List<ProductoTienda> findAll() throws Exception {
		return productoTiendaRepository.findAll();
	}
	
}
