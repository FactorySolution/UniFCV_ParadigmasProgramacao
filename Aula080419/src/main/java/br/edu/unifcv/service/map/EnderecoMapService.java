package br.edu.unifcv.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Endereco;
import br.edu.unifcv.service.EnderecoService;

@Service
public class EnderecoMapService extends AbstractMapService<Endereco, Long> implements EnderecoService {

	@Override
	public Set<Endereco> getAll() {
		return super.findAll();
	}

	@Override
	public Endereco findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Endereco saveOrUpdate(Endereco object) {
		return super.saveOrUpdate(object);
	}

	@Override
	public void delete(Endereco object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
