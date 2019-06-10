package br.edu.unifcv.faculdade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Autor extends BaseEntity {

	@NotEmpty(message = "Nome não pode ser vazio!!!")
	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Data de nascimento não pode ser vazio")
	private Date nascimento;

	@Column(length = 100)
	@NotEmpty(message = "Campo nacionalidade não pode ser vazio")
	private String nacionalidade;

	@OneToMany(mappedBy = "autor")
	@JsonInclude(value = Include.NON_EMPTY)
	private List<Livro> livros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
