package br.edu.unifcv.Aula110219.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifcv.Aula110219.model.Aluno;

@Service
public class AlunoService {

	private List<Aluno> alunoList = new ArrayList<Aluno>();

	public AlunoService() {
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

	public List<Aluno> getAlunos() {
		return alunoList;
	}

	public Aluno getAluno(Integer id) {
		return getAlunoById(id);
	}

	public Aluno insertAluno(Aluno aluno) {
		aluno.setId(alunoList.size() + 1);
		alunoList.add(aluno);
		return aluno;
	}

	public Aluno updateAluno(Integer id, Aluno aluno) {
		Aluno al = getAlunoById(id);
		al.setNome(aluno.getNome());
		al.setSobrenome(aluno.getSobrenome());
		al.setTelefone(aluno.getTelefone());
		alunoList.remove(al);
		alunoList.add(al);
		return al;
	}

	public void deleteAluno(Integer id) {
		Aluno al = getAlunoById(id);
		alunoList.remove(al);
	}

	private Aluno getAlunoById(Integer id) {
		return alunoList.stream().filter(aluno -> aluno.getId().equals(id)).findAny().orElse(null);

	}

}
