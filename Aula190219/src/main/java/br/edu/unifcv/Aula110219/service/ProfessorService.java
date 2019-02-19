package br.edu.unifcv.Aula110219.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifcv.Aula110219.model.Professor;

@Service
public class ProfessorService {
	
	private List<Professor> professor = new ArrayList<Professor>();
	
	public ProfessorService() {
		Professor P = new Professor();
		P.setId(1);
		P.setNome("renan");
		P.setMateria("Java");
		
		professor.add(P);
	}
	
	public List<Professor> getProfessores(){
		return professor;
	}
	
}
