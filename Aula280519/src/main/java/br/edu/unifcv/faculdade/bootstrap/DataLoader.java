package br.edu.unifcv.faculdade.bootstrap;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.faculdade.model.Autor;
import br.edu.unifcv.faculdade.model.Livro;
import br.edu.unifcv.faculdade.repository.AutorRepository;
import br.edu.unifcv.faculdade.repository.LivroRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	AutorRepository repository;

	@Autowired
	LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {

		Autor autor = new Autor();

		autor.setNome("Andre");
		autor.setNacionalidade("BR");
		autor.setNascimento(new Date());

		Autor b = repository.save(autor);

		Livro livro = new Livro();

		livro.setEditora("FCV");
		livro.setNome("JAVA");
		livro.setPublicacao(new Date());
		livro.setResumo("OLAAAA");
		livro.setAutor(b);

		//livroRepository.save(livro);

	}

}
