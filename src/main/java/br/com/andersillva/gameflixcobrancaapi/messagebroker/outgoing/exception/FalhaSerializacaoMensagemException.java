package br.com.andersillva.gameflixcobrancaapi.messagebroker.outgoing.exception;

public class FalhaSerializacaoMensagemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MENSAGEM_PADRAO = "Falha ao serializar o objeto para envio ao message broker.";

	public FalhaSerializacaoMensagemException() {
        super(MENSAGEM_PADRAO);
    }

	public FalhaSerializacaoMensagemException(String mensagem) {
        super(mensagem);
    }

}
