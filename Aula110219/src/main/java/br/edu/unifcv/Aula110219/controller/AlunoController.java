package br.edu.unifcv.Aula110219.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.Aula110219.model.Aluno;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {

	private List<Aluno> alunoList = new ArrayList<Aluno>();

	public AlunoController() {
		Aluno aluno1 = new Aluno();
		aluno1.setId(1);
		aluno1.setNome("André");
		aluno1.setSobrenome("Oliveira");
		aluno1.setTelefone("1123456789");

		Aluno aluno2 = new Aluno();
		aluno2.setId(2);
		aluno2.setNome("Aline");
		aluno2.setSobrenome("Priscila");
		aluno2.setTelefone("51466415");

		alunoList.add(aluno1);
		alunoList.add(aluno2);
	}

	@RequestMapping
	public List<Aluno> getAlunos() {
		return alunoList;
	}

	@RequestMapping("/{id}")
	public Aluno getAluno(@PathVariable("id") Integer id) {
		return getAlunoById(id);
	}

	private Aluno getAlunoById(Integer id) {
		return alunoList.
					stream().
					filter(aluno -> aluno.getId().equals(id)).findAny().
					orElse(null);

	}

	@RequestMapping(path = "/inserir", method = RequestMethod.POST)
	public Aluno setAluno(@RequestBody Aluno aluno) {
		aluno.setId(alunoList.size() + 1);
		alunoList.add(aluno);
		return aluno;
	}

	@RequestMapping(path = "/{id}/update", method = RequestMethod.PUT)
	public Aluno updateAluno(@PathVariable("id") Integer id, @RequestBody Aluno aluno) {

		Aluno al = getAlunoById(id);
		al.setNome(aluno.getNome());
		al.setSobrenome(aluno.getSobrenome());
		al.setTelefone(aluno.getTelefone());
		alunoList.remove(al);
		alunoList.add(al);
		return al;

	}

}
