package br.com.afferolab.papelaria.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(sequenceName = "PRODUTO_SEQ", allocationSize = 1, name = "ID" ,schema="DESENV")
	private Long id;
	
	private Long categoria;
	
	private Long detalhe;
	
	@Column(name="COD_BARRAS")
	private String codBarras;
	
	private String descricao;
	
	private String nome;
	
	private int quantidade;

	@Column(name="PRECO_MEDIO")
	private double precoMedio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(double precoMedio) {
		this.precoMedio = precoMedio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(Long detalhe) {
		this.detalhe = detalhe;
	}
	
}
