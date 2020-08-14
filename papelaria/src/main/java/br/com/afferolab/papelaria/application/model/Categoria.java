package br.com.afferolab.papelaria.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(sequenceName = "CATEGORIA_SEQ", allocationSize = 1, name = "ID" ,schema="DESENV")
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
