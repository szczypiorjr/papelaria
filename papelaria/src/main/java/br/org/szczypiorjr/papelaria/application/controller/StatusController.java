package br.org.szczypiorjr.papelaria.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	@GetMapping("/")
	public String index() {
		return "Aplicação Funcionando Normalmente!";
	}

}