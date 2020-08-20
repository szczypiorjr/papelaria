package br.org.szczypiorjr.papelaria.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.org.szczypiorjr.papelaria.application.constants.Constantes;

@Configuration
@EnableAutoConfiguration
@ComponentScan(Constantes.ROOT_PACKAGE)
public class PapelariaAPIStart extends SpringBootServletInitializer 
{
    public static void main(String[] args){ 
    	new PapelariaAPIStart().configure(new SpringApplicationBuilder(PapelariaAPIStart.class)).run(args);
    }
}


