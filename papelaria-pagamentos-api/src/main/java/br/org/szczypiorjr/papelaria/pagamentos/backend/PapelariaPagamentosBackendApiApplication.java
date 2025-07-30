package br.org.szczypiorjr.papelaria.pagamentos.backend;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PapelariaPagamentosBackendApiApplication {

	public static void main(String[] args) {
        SpringApplication.run(PapelariaPagamentosBackendApiApplication.class, args);
        System.out.println("Rodando API: Papelaria Pagamentos");
	}

}
