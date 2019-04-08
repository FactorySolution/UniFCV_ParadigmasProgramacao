package br.edu.unifcv.controller;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Void> saveProfessor(@RequestBody Professor professor) {
		Professor p = professorMapService.saveOrUpdate(professor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor) {
		return ResponseEntity.ok(professorMapService.saveOrUpdate(professor));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
		professorMapService.deleteById(id);
		return ResponseEntity.noContent().build();
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
