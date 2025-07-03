package br.org.szczypiorjr.papelaria.application.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(sequenceName = "CAT_SEQ", allocationSize = 1, name = "ID" ,schema="PAPELARIA")
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