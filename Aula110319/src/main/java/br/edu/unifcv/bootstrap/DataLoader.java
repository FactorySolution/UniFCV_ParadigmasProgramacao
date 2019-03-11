package br.edu.unifcv.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.model.Aluno;

@Component
public class DataLoader implements CommandLineRunner{

	@Autowired
	br.edu.unifcv.service.map.AlunoMapService AlunoMapService;
	
	@Override
	public void run(String... args) throws Exception {
		
		inserirDados();
	}

	private void inserirDados() {
		
		Aluno aluno = new Aluno();
		aluno.setNome("André"); 
		aluno.setSobreNome("Oliveira");
		aluno.setIdade(34);
		aluno.setRegistroAluno("123456");
		aluno.setSemestre("6° Semestre");
		AlunoMapService.save(aluno);
		
	}

}
