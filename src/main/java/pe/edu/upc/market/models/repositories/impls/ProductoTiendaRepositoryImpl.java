package pe.edu.upc.market.models.repositories.impls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.market.models.entities.ProductoTienda;
import pe.edu.upc.market.models.repositories.ProductoTiendaRepository;

@Named
@ApplicationScoped
public class ProductoTiendaRepositoryImpl implements ProductoTiendaRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MarketPU") //Se enlaza con el gestor de entidades declarado en el persistance
	private EntityManager em;

	@Override
	public ProductoTienda save(ProductoTienda entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public ProductoTienda update(ProductoTienda entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {		
		Optional<ProductoTienda> optional = findById(id);	
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<ProductoTienda> findById(Integer id) throws Exception {
		Optional<ProductoTienda> optional = Optional.empty();
		String qlstring = "SELECT c FROM ProductoTienda c WHERE c.id = ?1";		
		TypedQuery<ProductoTienda> query = em.createQuery(qlstring, ProductoTienda.class);		
		query.setParameter(1, id);			
		ProductoTienda productoTienda = query.getSingleResult();		
		if(productoTienda != null) {
			optional = Optional.of(productoTienda);
		}
		return optional; 
	}

	@Override
	public List<ProductoTienda> findAll() throws Exception {
		List<ProductoTienda> productoTiendas = new ArrayList<>();
        String qlString = "SELECT c FROM ProductoTienda c";       
        TypedQuery<ProductoTienda> query = em.createQuery(qlString, ProductoTienda.class);       
        productoTiendas = query.getResultList();
        return productoTiendas;
	}
	
}
