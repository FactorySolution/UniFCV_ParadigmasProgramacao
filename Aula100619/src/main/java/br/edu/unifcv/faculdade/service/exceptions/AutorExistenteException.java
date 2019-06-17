package br.edu.unifcv.faculdade.service.exceptions;

public class AutorExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
