package br.edu.unifcv.faculdade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro extends BaseEntity {

	@NotEmpty(message = "Nome não pode ser vazio")
	@Length(min = 5, max = 50, message = "Informe o tamanho correto")
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicacao;

	@NotEmpty(message = "Informe a editora do Livro")
	private String editora;

	@NotEmpty(message = "Informe o resumo do Livro")
	private String resumo;

	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonIgnore
	private Autor autor;
	
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
