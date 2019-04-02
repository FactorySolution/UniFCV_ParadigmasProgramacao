package br.edu.unifcv.service.exception;

public class RegraDeNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraDeNegocioException(String error) {
		super(error);
	}

}
