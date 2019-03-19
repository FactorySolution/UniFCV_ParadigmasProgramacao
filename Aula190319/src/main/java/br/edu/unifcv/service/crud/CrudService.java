package br.edu.unifcv.service.crud;

import java.util.Set;

public interface CrudService<T, ID> {

	Set<T> getAll();
	
	T findById(ID id);
	
	T saveOrUpdate(T object);

	void delete(T object);

	void deleteById(ID id);
}
