package br.edu.unifcv.faculdade.bootstrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.faculdade.model.Autor;
import br.edu.unifcv.faculdade.repository.AutorRepository;

@Component
public class DataLoader implements CommandLineRunner  {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void run(String... args) throws Exception {
		Autor a = new Autor();
		
		a.setNome("Andre");
		
		a = autorRepository.save(a);
		
		List<Autor> t = autorRepository.findAll();
		
		a.setNome("JAO");
		
		
		autorRepository.save(a);
		
		autorRepository.deleteById(a.getId());
		
	}

	

}
