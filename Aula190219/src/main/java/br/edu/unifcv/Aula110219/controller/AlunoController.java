package br.edu.unifcv.Aula110219.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.Aula110219.model.Aluno;
import br.edu.unifcv.Aula110219.service.AlunoService;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {

	// @Autowired
	private AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@RequestMapping
	public List<Aluno> getAlunos() {
		return alunoService.getAlunos();
	}

	@RequestMapping(path = "/{id}")
	public Aluno getAluno(@PathVariable("id") Integer id) {
		return alunoService.getAluno(id);
	}

	@RequestMapping(path = "/salvar", method = RequestMethod.POST)
	public Aluno saveAluno(@RequestBody Aluno aluno) {
		return alunoService.insertAluno(aluno);
	}

	@RequestMapping(path = "/{id}/update", method = RequestMethod.PUT)
	public Aluno updateAluno(@PathVariable("id") Integer id, 
			@RequestBody Aluno aluno) {
		return alunoService.updateAluno(id, aluno);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteAluno(@PathVariable("id") Integer id) {
		alunoService.deleteAluno(id);
	}

}
