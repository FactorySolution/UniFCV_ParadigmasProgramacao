package br.edu.unifcv.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.unifcv.model.Telefone;
import br.edu.unifcv.service.TelefoneService;

@Service
public class TelefoneMapService extends AbstractMapService<Telefone, Long> implements TelefoneService {

	@Override
	public Set<Telefone> getAll() {
		return super.findAll();
	}

	@Override
	public Telefone findById(Long id) {		
		return super.findById(id);
	}

	@Override
	public Telefone saveOrUpdate(Telefone object) {		
		return super.saveOrUpdate(object);
	}

	@Override
	public void delete(Telefone object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
