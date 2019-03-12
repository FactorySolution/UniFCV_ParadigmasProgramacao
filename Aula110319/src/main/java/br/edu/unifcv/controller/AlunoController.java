package br.edu.unifcv.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.model.Aluno;
import br.edu.unifcv.service.map.AlunoMapService;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {

	@Autowired
	AlunoMapService alunoMapService;

	@RequestMapping
	public Set<Aluno> getAll() {
		return alunoMapService.getAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Aluno getAlunoById(@PathVariable Long id) {
		return alunoMapService.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Aluno saveAluno(@RequestBody Aluno aluno) {
		return alunoMapService.save(aluno);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAluno(@RequestBody Aluno aluno) {
		alunoMapService.delete(aluno);
	}

	@RequestMapping(path = "{/id}", method = RequestMethod.DELETE)
	public void deleteAlunoById(@PathVariable Long id) {
		alunoMapService.deleteById(id);
	}

}








