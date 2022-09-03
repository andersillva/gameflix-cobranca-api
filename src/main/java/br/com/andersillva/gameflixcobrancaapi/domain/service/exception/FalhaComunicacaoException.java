package br.com.andersillva.gameflixcobrancaapi.domain.service.exception;

public class FalhaComunicacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MENSAGEM_PADRAO = "Falha de comunicação.";
	
	public FalhaComunicacaoException() {
        super(MENSAGEM_PADRAO);
    }

	public FalhaComunicacaoException(String mensagem) {
        super(mensagem);
    }

}
