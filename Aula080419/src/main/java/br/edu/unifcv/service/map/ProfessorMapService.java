package br.edu.unifcv.service.map;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Endereco;
import br.edu.unifcv.model.Professor;
import br.edu.unifcv.model.Telefone;
import br.edu.unifcv.service.ProfessorService;
import br.edu.unifcv.service.exception.RecursoNaoEncontradoException;
import br.edu.unifcv.service.exception.RegraDeNegocioException;

@Service
public class ProfessorMapService extends AbstractMapService<Professor, Long> implements ProfessorService {

	@Autowired
	EnderecoMapService enderecoMapService;

	@Autowired
	TelefoneMapService telefoneMapService;

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
		if (isDadosOk(object)) {
			Professor p = super.saveOrUpdate(object);
			if (object.getTelefone() != null) {
				object.getTelefone().setProfessor_id(p.getId());
				;
				this.saveOrUpdateTelefone(object.getTelefone());
			}
			if (object.getEndereco().size() > 0) {
				this.saveOrUpdateEndereco(object.getEndereco(), p.getId());
			}
			return p;
		}

		throw new RegraDeNegocioException("Preencha todos os dados");
	}

	private void saveOrUpdateTelefone(Telefone telefone) {
		if (telefone.getId() == null) {
			Telefone t = telefoneMapService.saveOrUpdate(telefone);
			telefone.setId(t.getId());
		}

	}

	private void saveOrUpdateEndereco(List<Endereco> endereco, Long id) {
		endereco.forEach(e -> {
			if (e.getId() == null) {
				e.setProfessor_id(id);
				Endereco saveEndereco = enderecoMapService.saveOrUpdate(e);
				e.setId(saveEndereco.getId());
			}
		});

	}

	private boolean isDadosOk(Professor object) {
		return (!isNotEmpty(object.getNome()) && !isNotEmpty(object.getSobreNome())
				&& isLengthValid(object.getNome(), 4) && isLengthValid(object.getNome(), 4));
	}

	@Override
	public void delete(Professor object) {
		if (object.getEndereco().size() > 0)
			deleteEndereco(object.getEndereco());
		if (object.getTelefone() != null)
			deleteTelefone(object.getTelefone());
		super.delete(object);
	}

	private void deleteTelefone(Telefone telefone) {
		try {
			telefoneMapService.delete(telefone);
		} catch (Exception e) {

		}
	}

	private void deleteEndereco(List<Endereco> endereco) {
		try {
			endereco.forEach(e -> enderecoMapService.delete(e));
		} catch (Exception e) {

		}
	}

	@Override
	public void deleteById(Long id) {
		this.findById(id);
		super.deleteById(id);

	}

	@Override
	public Professor findByNome(String nome) {
		Professor p = map.values().stream().filter(e -> e.getNome().trim().equalsIgnoreCase(nome)).findFirst()
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não localizado: " + nome));
		return p;
	}

	@Override
	public Professor findBySobreNome(String sobreNome) {
		for (Entry<Long, Professor> p : map.entrySet()) {
			if (p.getValue().getSobreNome().trim().equalsIgnoreCase(sobreNome)) {
				return p.getValue();
			}
		}
		throw new RecursoNaoEncontradoException("Usuario não localizado: " + sobreNome);
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
