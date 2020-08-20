package br.org.szczypiorjr.papelaria.application.filters;
import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSResponseFilter
implements ContainerResponseFilter {

	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.add(CORSParameters.ACCESS_CONTROL_ALLOW_ORIGIN.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_ORIGIN.getValor());
		headers.add(CORSParameters.ACCESS_CONTROL_ALLOW_METHODS_2.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_METHODS_2.getValor());
		headers.add(CORSParameters.ACCESS_CONTROL_ALLOW_HEADERS_2.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_HEADERS_2.getValor());
	}
}
