package br.edu.unifcv.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
