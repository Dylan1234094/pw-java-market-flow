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

import pe.edu.upc.market.models.entities.Producto;
import pe.edu.upc.market.models.repositories.ProductoRepository;

@Named
@ApplicationScoped
public class ProductoRepositoryImpl implements ProductoRepository, Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "MarketPU") //Se enlaza con el gestor de entidades declarado en el persistance
	private EntityManager em;
	
	@Override
	public Producto save(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Declara y asigna el resultado de la búsqueda
		Optional<Producto> optional = findById(id);
		//Verifica si optional contiene un objeto
		if(optional.isPresent()) {
			//remuevo el objeto
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		Optional<Producto> optional = Optional.empty();
		String qlstring = "SELECT c FROM Producto c WHERE c.id = ?1";		
		TypedQuery<Producto> query = em.createQuery(qlstring, Producto.class);		
		query.setParameter(1, id);			
		Producto producto = query.getSingleResult();		
		if(producto != null) {
			optional = Optional.of(producto);
		}
		return optional; 
	}

	@Override
	public List<Producto> findAll() throws Exception {
        List<Producto> productos = new ArrayList<>();
        String qlString = "SELECT c FROM Producto c";       
        TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);       
        productos = query.getResultList();
        return productos;
	}

	@Override
	public List<Producto> findByNombre(String nombre) throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		String qlString = "SELECT c FROM Producto c where c.nombre LIKE ?1";
		TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);
		query.setParameter(1,  "%" + nombre.toUpperCase() + "%");
		productos = query.getResultList();
		return productos;
	}
	
}
