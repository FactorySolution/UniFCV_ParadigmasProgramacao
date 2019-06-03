package br.edu.unifcv.faculdade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifcv.faculdade.model.Autor;
import br.edu.unifcv.faculdade.repository.AutorRepository;
import br.edu.unifcv.faculdade.service.exceptions.AutorExistenteException;
import br.edu.unifcv.faculdade.service.exceptions.AutorNaoEncontradoException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listar() {
		return autorRepository.findAll();
	}	
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autorRepository.findById(autor.getId()).get();
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autorRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autorRepository.findById(id).get();
		
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		return autor;
	}
	
	public void deletar(Long id) {
		autorRepository.deleteById(id);
	}
		
}
	

