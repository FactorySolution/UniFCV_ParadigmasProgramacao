package br.edu.unifcv.service;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.service.crud.CrudService;

public interface AlunoService extends CrudService<Aluno, Long>{
   
	Aluno findByName(String nome);
}
