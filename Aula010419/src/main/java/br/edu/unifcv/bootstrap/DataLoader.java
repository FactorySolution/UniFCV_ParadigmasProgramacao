package br.edu.unifcv.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unifcv.model.Endereco;
import br.edu.unifcv.model.Professor;
import br.edu.unifcv.model.Telefone;
import br.edu.unifcv.service.map.ProfessorMapService;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private ProfessorMapService professorMapService;

	@Override
	public void run(String... args) throws Exception {
		saveData();
	}

	private void saveData() {
		
		Professor p1 = new Professor();
		
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua xpto");
		e1.setBairro("Centro");
		e1.setCidade("Maringa");
		e1.setEstado("PR");
		e1.setNumero("123");
		
		Endereco e2 = new Endereco();
		e2.setLogradouro("Rua XXXXXXXXXXXX");
		e2.setBairro("Centro");
		e2.setCidade("Sarandi");
		e2.setEstado("PR");
		e2.setNumero("N/A");
		
		
	    List<Endereco> lista = new ArrayList<>();
	    lista.add(e1);
	    lista.add(e2);
	    
	    Telefone t1 = new Telefone();
	    t1.setContato("Contato XXXX");
	    t1.setTelefone("44999995555");

		p1.setNome("André");
		p1.setSobreNome("Oliveira");
		p1.setIdade(34);
		p1.setPeriodo("Noturno");
		p1.setFaculdade("UniFCV");
		p1.setTurma("5° Semestre");
		p1.setAno("2019");
		//p1.setEndereco(lista);
		p1.setTelefone(t1);

		Professor p2 = new Professor();
		
		Telefone t2 = new Telefone();
	    t2.setContato("Contato YYYYYYY");
	    t2.setTelefone("44555557777");

		p2.setNome("Aline");
		p2.setSobreNome("Priscila");
		p2.setIdade(38);
		p2.setPeriodo("Noturno");
		p2.setFaculdade("UniFCV");
		p2.setTurma("6° Semestre");
		p2.setAno("2019");
		//p2.setEndereco(lista);
		p2.setTelefone(t2);

		this.professorMapService.saveOrUpdate(p1);
		this.professorMapService.saveOrUpdate(p2);
	}

}
