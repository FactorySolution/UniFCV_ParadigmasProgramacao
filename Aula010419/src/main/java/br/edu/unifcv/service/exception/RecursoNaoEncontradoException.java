package br.edu.unifcv.service.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoException(String error) {
		super(error);
	}

}
