package br.edu.unifcv.faculdade.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.unifcv.faculdade.model.Comentario;
import br.edu.unifcv.faculdade.model.Livro;
import br.edu.unifcv.faculdade.repository.ComentarioRepository;
import br.edu.unifcv.faculdade.repository.LivroRepository;
import br.edu.unifcv.faculdade.service.exceptions.LivroNaoEncontradoException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if(!livro.isPresent()) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
		return livro.get();
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livroRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		return comentarioRepository.save(comentario);
	}
	
	
	public List<Comentario> getAllComentario(Long livroId) {
		Livro livro = buscar(livroId);
		return livro.getComentarios();
	}

}
