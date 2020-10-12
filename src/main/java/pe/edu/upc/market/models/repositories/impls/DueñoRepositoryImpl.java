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

import pe.edu.upc.market.models.entities.Due�o;
import pe.edu.upc.market.models.repositories.Due�oRepository;

@Named //Esta clase podr� ser inyectada posteriormente
@ApplicationScoped
public class Due�oRepositoryImpl implements Due�oRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MarketPU") //Se enlaza con el gestor de entidades declarado en el persistance
	private EntityManager em;
	
	@Override
	public Due�o save(Due�o entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Due�o update(Due�o entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Declara y asigna el resultado de la b�squeda
		Optional<Due�o> optional = findById(id);
		//Verifica si optional contiene un objeto
		if(optional.isPresent()) {
			//remuevo el objeto
			em.remove(optional.get());
		}
		
	}

	@Override
	public Optional<Due�o> findById(Integer id) throws Exception {
		// Declara la variable a retornar 
		Optional<Due�o> optional = Optional.empty();
		//elaborar el JPQL
		String qlstring = "SELECT c FROM Due�o c WHERE c.id = ?1";
		//Crear la consulta
		TypedQuery<Due�o> query = em.createQuery(qlstring, Due�o.class);
		//Estableciendo los parametros: id
		query.setParameter(1, id);
		//Obtener el resultado de la consulta
		Due�o due�o = query.getSingleResult();
		//Verificar la existencia del objeto
		if(due�o != null) {
			optional = Optional.of(due�o);
		}
		return optional; //optional se devuelve vacio si no se encuentra objeto
	}

	@Override
	public List<Due�o> findAll() throws Exception {
		 // Declara la variable a retornar
        List<Due�o> due�os = new ArrayList<>();
        // Elaborar el JPQL
        String qlString = "SELECT c FROM Due�o c";
        // Crear la consulta
        TypedQuery<Due�o> query = em.createQuery(qlString, Due�o.class);
        // Obtener el resultado de la consulta
        due�os = query.getResultList();
        return due�os;
	}

	@Override
	public List<Due�o> findByNombre(String nombre) throws Exception {
		List<Due�o> due�os = new ArrayList<Due�o>();
		String qlString = "SELECT c FROM Due�o c where c.nombre LIKE ?1";
		TypedQuery<Due�o> query = em.createQuery(qlString, Due�o.class);
		query.setParameter(1,  "%" + nombre.toUpperCase() + "%");
		due�os = query.getResultList();
		return due�os;
	}

	@Override
	public Optional<Due�o> findByNumeroDocumento(String numeroDocumento) throws Exception {
		Optional<Due�o> optional = Optional.empty();
		String qlstring = "SELECT c FROM Due�o c WHERE c.numeroDocumento = ?1";		
		TypedQuery<Due�o> query = em.createQuery(qlstring, Due�o.class);		
		query.setParameter(1, numeroDocumento);			
		Due�o due�o = query.getSingleResult();		
		if(due�o != null) {
			optional = Optional.of(due�o);
		}
		return optional; 
	}

}
