package br.org.szczypiorjr.papelaria.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -159049506471288856L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
	@SequenceGenerator(sequenceName = "PRO_SEQ", allocationSize = 1, name = "ID" ,schema="PAPELARIA")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID")
	private Categoria categoria;
	
	private String detalhe;
	
	@Column(name="COD_BARRAS")
	private String codBarras;
	
	private String descricao;
	
	private String nome;
	
	private int quantidade;

	@Column(name="PRECO")
	private double preco;

	@Column(name="PRECO_COM_DESCONTO")
	private double precoDesconto;

	@Column(name="DESCONTO_PERCENTUAL")
	private double descontoPercentual;
	
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

	public double getPrecoDesconto() {
		return precoDesconto;
	}

	public void setPrecoDesconto(double precoDesconto) {
		this.precoDesconto = precoDesconto;
	}

	public double getDescontoPercentual() {
		return descontoPercentual;
	}

	public void setDescontoPercentual(double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
}