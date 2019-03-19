package br.edu.unifcv.service.map;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.ProfessorService;
import br.edu.unifcv.service.exception.RecursoNaoEncontradoException;

@Service
public class ProfessorMapService extends AbstractMapService<Professor, Long> implements ProfessorService {

	@Override
	public Set<Professor> getAll() {
		return super.findAll();
	}

	@Override
	public Professor findById(Long id) {
		Optional<Professor> p = Optional.ofNullable(super.findById(id));
		if (p.isPresent())
			return p.get();
		throw new RecursoNaoEncontradoException("Não achei o id : " + id);
	}

	@Override
	public Professor saveOrUpdate(Professor object) {

		if (!isNotEmpty(object.getNome()) && !isNotEmpty(object.getSobreNome()) && isLengthValid(object.getNome(), 4)
				&& isLengthValid(object.getNome(), 4)) {
			return super.save(object);
		}

		return null;
	}

	@Override
	public void delete(Professor object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

	@Override
	public Professor findByNome(String nome) {
		Professor p = map.values().stream().filter(e -> e.getNome().trim().equalsIgnoreCase(nome)).findFirst().get();
		return p;
	}

	@Override
	public Professor findBySobreNome(String sobreNome) {
		for (Entry<Long, Professor> p : map.entrySet()) {
			if (p.getValue().getSobreNome().trim().equalsIgnoreCase(sobreNome)) {
				return p.getValue();
			}
		}
		return null;
	}

	@Override
	public Long count() {
		return Collections.max(map.keySet()).longValue();
	}

	private boolean isNotEmpty(String value) {
		return value.trim().isEmpty();
	}

	private boolean isLengthValid(String value, int Length) {
		return value.trim().length() > Length;
	}

}
