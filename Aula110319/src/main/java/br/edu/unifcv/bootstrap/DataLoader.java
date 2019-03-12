package br.edu.unifcv.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.map.ProfessorMapService;
import br.edu.unifcv.service.map.AlunoMapService;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	AlunoMapService alunoMapService;
	
	@Autowired
	ProfessorMapService professorMapService;
	
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
		alunoMapService.save(aluno);
		
		Professor professor = new Professor();
		professor.setNome("Andre");
		professor.setIdade(35);
		professor.setSobreNome("Oliveira");
		
		professorMapService.save(professor);
		
	}

}
