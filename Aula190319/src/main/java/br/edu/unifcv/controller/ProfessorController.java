package br.edu.unifcv.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifcv.model.Professor;
import br.edu.unifcv.service.map.ProfessorMapService;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

	@Autowired
	ProfessorMapService professorMapService;

	@RequestMapping
	public Set<Professor> getAll() {
		return professorMapService.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> getProfessor(@PathVariable Long id) {
		return ResponseEntity.ok(professorMapService.findById(id)); 
	}

	@RequestMapping(method = RequestMethod.POST)
	public Professor saveProfessor(@RequestBody Professor professor) {
		return professorMapService.saveOrUpdate(professor);
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public Professor updateProfessor(@RequestBody Professor professor) {
		return professorMapService.saveOrUpdate(professor);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteProfessor(@PathVariable Long id) {
		professorMapService.deleteById(id);

	}

	@RequestMapping(path = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Professor> getByName(@PathVariable String nome) {
		try {
			Professor p = professorMapService.findByNome(nome);
			return ResponseEntity.ok(p);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(path = "/sobrenome/{sobrenome}", method = RequestMethod.GET)
	public ResponseEntity<Professor> getBySobrenome(@PathVariable String sobrenome) {
		try {
			Professor p = professorMapService.findBySobreNome(sobrenome);
			return ResponseEntity.ok(p);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(path = "/registros")
	public Long count() {
		return professorMapService.count();
	}

}
