package br.com.andersillva.gameflixcobrancaapi.messaging.outgoing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.andersillva.gameflixcobrancaapi.domain.model.Cobranca;
import br.com.andersillva.gameflixcobrancaapi.messaging.outgoing.dto.MensagemPedidoPagamentoRegistradoDTO;
import br.com.andersillva.gameflixcobrancaapi.messaging.outgoing.exception.FalhaSerializacaoMensagemException;

@Component
public class EventoPedidoPagamentoRegistradoImpl implements EventoPedidoPagamentoRegistrado {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Value("${app.topic.pedido-pagamento-registrado}")
    private String PAGAMENTO_REGISTRADO;

    public EventoPedidoPagamentoRegistradoImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void gerarMensagem(Cobranca cobranca) {

		var mensagemDTO = new MensagemPedidoPagamentoRegistradoDTO(cobranca);
		String mensagem;
		try {
			mensagem = objectMapper.writeValueAsString(mensagemDTO);
		} catch (JsonProcessingException e) {
			throw new FalhaSerializacaoMensagemException("Falha ao serializar o registro de pagamento para envio ao message broker.");
		}
        kafkaTemplate.send(PAGAMENTO_REGISTRADO, mensagem);

	}

}
