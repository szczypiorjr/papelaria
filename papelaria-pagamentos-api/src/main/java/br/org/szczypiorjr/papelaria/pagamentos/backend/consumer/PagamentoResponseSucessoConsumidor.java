package br.org.szczypiorjr.papelaria.pagamentos.backend.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.org.szczypiorjr.papelaria.pagamentos.backend.facade.PagamentoFacade;

@Service
public class PagamentoResponseSucessoConsumidor {

    @Autowired private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"papelaria-pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        pagamentoFacade.sucessoPagamento(payload);
    }
}
