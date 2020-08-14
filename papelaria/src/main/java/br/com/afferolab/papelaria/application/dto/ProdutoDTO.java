package br.com.afferolab.papelaria.application.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	private Long id;
	
	private Long CategoriaId;
	
	private String detalhe;
	
	private String codBarras;
	
	private String descricao;
	
	private String nome;
	
	private int quantidade;

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


	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public Long getCategoriaId() {
		return CategoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		CategoriaId = categoriaId;
	}
	
}
