package br.org.szczypiorjr.message.queueing.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSucessoProdutor {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
            "papelaria-pagamento-response-sucesso-exchange",
            "papelaria-pagamento-response-sucesso-rout-key",
            mensagem);
    }
}
