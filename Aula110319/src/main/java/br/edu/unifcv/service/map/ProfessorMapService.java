package br.edu.unifcv.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.ProfessorService;

@Service
public class ProfessorMapService extends AbstractMapService<Professor, Long> implements ProfessorService {

	@Override
	public Set<Professor> getAll() {
		return super.findAll();
	}
	
	@Override
	public Professor findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Professor save(Professor professor) {
		return super.save(professor);
	}
	
	@Override
	public void delete(Professor object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	

	

}
