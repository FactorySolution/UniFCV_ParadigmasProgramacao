package br.edu.unifcv.service.map;

import java.util.Set;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.ProfessorService;

public class ProfessorMapService extends AbstractMapService<Professor, Long> implements ProfessorService {

	@Override
	public Set<Professor> getAll() {
		return super.findAll();
	}

	@Override
	public Professor save(Professor professor) {
		return super.save(professor);
	}

}
