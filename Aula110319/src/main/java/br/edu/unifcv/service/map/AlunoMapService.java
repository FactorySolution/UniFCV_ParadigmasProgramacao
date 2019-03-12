package br.edu.unifcv.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.service.AlunoService;

@Service
public class AlunoMapService extends AbstractMapService<Aluno, Long> implements AlunoService {

	@Override
	public Set<Aluno> getAll() {
		return super.findAll();
	}

	@Override
	public Aluno save(Aluno aluno) {
		return super.save(aluno);
	}

	@Override
	public Aluno findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Aluno object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

	@Override
	public Aluno findByName(String nome) {

		return null;
	}

}
