package br.edu.unifcv.model;

public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String Semestre;
	private String registroAluno;

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}

}
