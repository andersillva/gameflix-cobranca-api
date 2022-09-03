package br.com.andersillva.gameflixcobrancaapi.messaging.incoming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.andersillva.gameflixcobrancaapi.domain.service.CobrancaPedidoService;
import br.com.andersillva.gameflixcobrancaapi.messaging.incoming.dto.MensagemPedidoRecebidoDTO;

@Component
public class EventoPedidoRecebido {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private final CobrancaPedidoService cobrancaPedidoService;

    public EventoPedidoRecebido(CobrancaPedidoService cobrancaPedidoService) {
        this.cobrancaPedidoService = cobrancaPedidoService;
    }

    @KafkaListener(topics = "${app.topic.pedido-recebido}")
    public void consume(@Payload String message, Acknowledgment ack) throws JsonProcessingException {

        var mensagemPedidoRecebidoDTO = mapper.readValue(message, MensagemPedidoRecebidoDTO.class);
        cobrancaPedidoService.cobrarPedido(mensagemPedidoRecebidoDTO.converter());
        ack.acknowledge();

    }

}
