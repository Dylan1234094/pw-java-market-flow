package pe.edu.upc.market.services;

import java.util.List;
import java.util.Optional;

public interface CrudService <T,ID> { //T = templates(entity), ID
	//devuelve un objeto función(obtiene un objeto)
	T save(T entity) throws Exception; //Exception evita que la aplicación se cuelgue
	T update(T entity) throws Exception;
	void deleteById(ID id) throws Exception; //define que se borra por ID tambien se puede borrar por objeto 
	Optional<T> findById(ID id) throws Exception; //Optional -> si no encuentras el contenido, se devuelve una caja vacía
	//Se instancia el findById porque es general para todas las entidades 
	//Si se usara finByname todos las entidades no tienen ese atributo 
	List<T> findAll() throws Exception;
}