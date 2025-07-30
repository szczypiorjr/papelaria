package br.org.szczypiorjr.papelaria.pagamentos.backend.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.szczypiorjr.papelaria.pagamentos.backend.dto.PagamentoDTO;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {
    @Autowired private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar (PagamentoDTO pagamento) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
            "papelaria-pagamento-request-exchange",
            "papelaria-pagamento-request-rout-key",
            objectMapper.writeValueAsString(pagamento)
        );
    }
}
