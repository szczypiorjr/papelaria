package br.org.szczypiorjr.papelaria.pagamentos.backend.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.org.szczypiorjr.papelaria.pagamentos.backend.facade.PagamentoFacade;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumidor {
    @Autowired private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = {"papelaria-pagamento-response-erro-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.erroPagamento (payload);
    }
}
