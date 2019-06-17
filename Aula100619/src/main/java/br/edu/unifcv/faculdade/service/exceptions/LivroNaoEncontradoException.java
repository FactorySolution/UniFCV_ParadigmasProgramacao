package br.edu.unifcv.faculdade.service.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
