package br.org.szczypiorjr.message.queueing.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.org.szczypiorjr.message.queueing.producer.PagamentoErroProdutor;
import br.org.szczypiorjr.message.queueing.producer.PagamentoSucessoProdutor;

import java.util.Random;

@Component
public class PagamentoRequestConsumidor {
    @Autowired private PagamentoErroProdutor erroProdutor;
    @Autowired private PagamentoSucessoProdutor sucessoProdutor;

    @RabbitListener(queues = { "papelaria-pagamento-request-queue"})
    public void receberMensagem (@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Mensagem de sucesso Pagamento " + message);
        } else {
            erroProdutor.gerarResposta("ERRO no pagamento " + message);
        }
    }
}
