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

import pe.edu.upc.market.models.entities.Dueño;
import pe.edu.upc.market.models.repositories.DueñoRepository;

@Named //Esta clase podrá ser inyectada posteriormente
@ApplicationScoped
public class DueñoRepositoryImpl implements DueñoRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MarketPU") //Se enlaza con el gestor de entidades declarado en el persistance
	private EntityManager em;
	
	@Override
	public Dueño save(Dueño entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Dueño update(Dueño entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Declara y asigna el resultado de la búsqueda
		Optional<Dueño> optional = findById(id);
		//Verifica si optional contiene un objeto
		if(optional.isPresent()) {
			//remuevo el objeto
			em.remove(optional.get());
		}
		
	}

	@Override
	public Optional<Dueño> findById(Integer id) throws Exception {
		// Declara la variable a retornar 
		Optional<Dueño> optional = Optional.empty();
		//elaborar el JPQL
		String qlstring = "SELECT c FROM Dueño c WHERE c.id = ?1";
		//Crear la consulta
		TypedQuery<Dueño> query = em.createQuery(qlstring, Dueño.class);
		//Estableciendo los parametros: id
		query.setParameter(1, id);
		//Obtener el resultado de la consulta
		Dueño dueño = query.getSingleResult();
		//Verificar la existencia del objeto
		if(dueño != null) {
			optional = Optional.of(dueño);
		}
		return optional; //optional se devuelve vacio si no se encuentra objeto
	}

	@Override
	public List<Dueño> findAll() throws Exception {
		 // Declara la variable a retornar
        List<Dueño> dueños = new ArrayList<>();
        // Elaborar el JPQL
        String qlString = "SELECT c FROM Dueño c";
        // Crear la consulta
        TypedQuery<Dueño> query = em.createQuery(qlString, Dueño.class);
        // Obtener el resultado de la consulta
        dueños = query.getResultList();
        return dueños;
	}

	@Override
	public List<Dueño> findByNombre(String nombre) throws Exception {
		List<Dueño> dueños = new ArrayList<Dueño>();
		String qlString = "SELECT c FROM Dueño c where c.nombre LIKE ?1";
		TypedQuery<Dueño> query = em.createQuery(qlString, Dueño.class);
		query.setParameter(1,  "%" + nombre.toUpperCase() + "%");
		dueños = query.getResultList();
		return dueños;
	}

	@Override
	public Optional<Dueño> findByNumeroDocumento(String numeroDocumento) throws Exception {
		Optional<Dueño> optional = Optional.empty();
		String qlstring = "SELECT c FROM Dueño c WHERE c.numeroDocumento = ?1";		
		TypedQuery<Dueño> query = em.createQuery(qlstring, Dueño.class);		
		query.setParameter(1, numeroDocumento);			
		Dueño dueño = query.getSingleResult();		
		if(dueño != null) {
			optional = Optional.of(dueño);
		}
		return optional; 
	}

}
