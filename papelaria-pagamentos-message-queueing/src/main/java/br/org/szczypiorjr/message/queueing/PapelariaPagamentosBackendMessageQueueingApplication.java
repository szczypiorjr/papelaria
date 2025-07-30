package br.org.szczypiorjr.message.queueing;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PapelariaPagamentosBackendMessageQueueingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapelariaPagamentosBackendMessageQueueingApplication.class, args);
        System.out.println("Rodando: papelaria-pagamentos-message-queueing");
	}

}
