package br.com.afferolab.papelaria.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("br.com.afferolab.papelaria.application")
public class PapelariaStart extends SpringBootServletInitializer 
{
    public static void main(String[] args) 
    { 
    	new PapelariaStart().configure(new SpringApplicationBuilder(PapelariaStart.class)).run(args);
    }

}
