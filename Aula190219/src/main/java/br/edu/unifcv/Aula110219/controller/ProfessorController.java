package br.edu.unifcv.Aula110219.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.Aula110219.model.Professor;
import br.edu.unifcv.Aula110219.service.ProfessorService;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService ps;

	@RequestMapping
	public List<Professor> getProfessore() {
		return ps.getProfessores();
	}
}
