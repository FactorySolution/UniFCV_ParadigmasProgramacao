package br.edu.unifcv.Aula110219.model;

public class Aluno {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String telefone;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + "]";
	}

	
}
