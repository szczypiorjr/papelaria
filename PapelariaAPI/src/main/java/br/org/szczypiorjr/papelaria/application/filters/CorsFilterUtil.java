package br.org.szczypiorjr.papelaria.application.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterUtil implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		final HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader(CORSParameters.ACCESS_CONTROL_ALLOW_ORIGIN.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_ORIGIN.getValor());
        response.setHeader(CORSParameters.ACCESS_CONTROL_ALLOW_METHODS_1.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_METHODS_1.getValor());
        response.setHeader(CORSParameters.ACCESS_CONTROL_ALLOW_HEADERS_1.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_HEADERS_1.getValor());
        response.setHeader(CORSParameters.ACCESS_CONTROL_ALLOW_CREDENTIALS.getParametro(),CORSParameters.ACCESS_CONTROL_ALLOW_CREDENTIALS.getValor());
        response.setHeader(CORSParameters.ACCESS_CONTROL_EXPOSE_HEADERS.getParametro(),CORSParameters.ACCESS_CONTROL_EXPOSE_HEADERS.getValor());
        response.setHeader(CORSParameters.ACCESS_CONTROL_MAX_AGE.getParametro(),CORSParameters.ACCESS_CONTROL_MAX_AGE.getValor());
        
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod()))
        	response.setStatus(HttpServletResponse.SC_OK);
        else
        	chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() { }

	@Override
	public void init(FilterConfig arg0) throws ServletException { }
}
