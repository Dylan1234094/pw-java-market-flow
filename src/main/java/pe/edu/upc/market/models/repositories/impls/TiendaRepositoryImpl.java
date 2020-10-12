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

import pe.edu.upc.market.models.entities.Tienda;
import pe.edu.upc.market.models.repositories.TiendaRepository;

@Named
@ApplicationScoped
public class TiendaRepositoryImpl implements TiendaRepository, Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "MarketPU") //Se enlaza con el gestor de entidades declarado en el persistance
	private EntityManager em;
	
	@Override
	public Tienda save(Tienda entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Tienda update(Tienda entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Tienda> optional = findById(id);	
		if(optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Tienda> findById(Integer id) throws Exception {
		Optional<Tienda> optional = Optional.empty();
		String qlstring = "SELECT c FROM Tienda c WHERE c.id = ?1";		
		TypedQuery<Tienda> query = em.createQuery(qlstring, Tienda.class);		
		query.setParameter(1, id);			
		Tienda tienda = query.getSingleResult();		
		if(tienda != null) {
			optional = Optional.of(tienda);
		}
		return optional; 
	}

	@Override
	public List<Tienda> findAll() throws Exception {
		List<Tienda> tiendas = new ArrayList<>();
        String qlString = "SELECT c FROM Tienda c";       
        TypedQuery<Tienda> query = em.createQuery(qlString, Tienda.class);       
        tiendas = query.getResultList();
        return tiendas;
	}

	@Override
	public List<Tienda> findByNombre(String nombre) throws Exception {
		List<Tienda> tiendas = new ArrayList<Tienda>();
		String qlString = "SELECT c FROM Tienda c where c.nombre LIKE ?1";
		TypedQuery<Tienda> query = em.createQuery(qlString, Tienda.class);
		query.setParameter(1,  "%" + nombre.toUpperCase() + "%");
		tiendas = query.getResultList();
		return tiendas;
	}

}
