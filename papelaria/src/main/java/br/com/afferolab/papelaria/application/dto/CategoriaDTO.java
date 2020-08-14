package br.com.afferolab.papelaria.application.dto;

import java.io.Serializable;


public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	
	private Long id;
	
	private String nome;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}