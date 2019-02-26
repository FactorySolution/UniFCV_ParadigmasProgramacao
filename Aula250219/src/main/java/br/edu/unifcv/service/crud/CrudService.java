package br.edu.unifcv.service.crud;

import java.util.Set;

public interface CrudService<T, ID> {

	Set<T> getAll();
}
