package br.edu.unifcv.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.map.ProfessorMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private ProfessorMapService professorMapService;

	public DataLoader(ProfessorMapService professorMapService) {
		this.professorMapService = professorMapService;
	}

	@Override
	public void run(String... args) throws Exception {
		saveData();
	}

	private void saveData() {
		Professor p1 = new Professor();

		p1.setNome("André");
		p1.setSobreNome("Oliveira");
		p1.setIdade(34);
		p1.setPeriodo("Noturno");
		p1.setFaculdade("UniFCV");
		p1.setTurma("5° Semestre");
		p1.setAno("2019");

		Professor p2 = new Professor();

		p2.setNome("Aline");
		p2.setSobreNome("Priscila");
		p2.setIdade(38);
		p2.setPeriodo("Noturno");
		p2.setFaculdade("UniFCV");
		p2.setTurma("6° Semestre");
		p2.setAno("2019");

		this.professorMapService.saveOrUpdate(p1);
		this.professorMapService.saveOrUpdate(p2);
	}

}
