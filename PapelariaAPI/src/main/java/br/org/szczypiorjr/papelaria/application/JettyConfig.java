package br.org.szczypiorjr.papelaria.application;

import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.szczypiorjr.papelaria.application.constants.Constantes;


@Configuration
public class JettyConfig {

	@Bean
	public JettyEmbeddedServletContainerFactory  jettyEmbeddedServletContainerFactory() {
	    JettyEmbeddedServletContainerFactory jettyContainer = 
	      new JettyEmbeddedServletContainerFactory();
	     
	    jettyContainer.setPort(Constantes.JETTY_CONTAINER_PORT);
	    jettyContainer.setContextPath(Constantes.CONTEXT_PATH);
	    return jettyContainer;
	}
}