package br.edu.unifcv.faculdade.model;

import javax.persistence.Entity;

@Entity
public class Autor extends BaseEntity {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	


}
