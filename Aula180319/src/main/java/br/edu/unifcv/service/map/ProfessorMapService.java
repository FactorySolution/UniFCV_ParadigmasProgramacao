package br.edu.unifcv.service.map;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

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
		return map.values().stream().filter(professor -> professor.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
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
