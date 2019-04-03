package br.edu.unifcv.service;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.crud.CrudService;

public interface ProfessorService extends CrudService<Professor, Long> {
	
	Professor findByNome(String nome);
	Professor findBySobreNome(String sobreNome);
	Long count();

}
