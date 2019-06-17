package br.edu.unifcv.faculdade.service.exceptions;

public class AutorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
