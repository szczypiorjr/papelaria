package br.org.szczypiorjr.papelaria.application.util;

import java.util.Optional;

import br.org.szczypiorjr.papelaria.application.dto.ProdutoDTO;
import br.org.szczypiorjr.papelaria.application.model.Categoria;
import br.org.szczypiorjr.papelaria.application.model.Produto;

public class ProdutoTradutor {
	
	public static Produto dto2model(Produto produto,ProdutoDTO produtodto,Categoria categoriaProduto) {
		produto.setId(produtodto.getId());
		produto.setCategoria(categoriaProduto);
		produto.setCodBarras(produtodto.getCodBarras());
		produto.setDescricao(produtodto.getDescricao());
		produto.setDetalhe(produtodto.getDetalhe());
		produto.setNome(produtodto.getNome());
		produto.setPreco(produtodto.getPreco());
		produto.setPrecoDesconto(produtodto.getPrecoDesconto());
		produto.setDescontoPercentual(produtodto.getDescontoPercentual());
		produto.setQuantidade(produtodto.getQuantidade());
		return produto; 
	}
	
	public static ProdutoDTO model2dto(Produto produto) {
		ProdutoDTO produtodto= new ProdutoDTO();
		produtodto.setId(produto.getId());
		produtodto.setNome(produto.getNome());
		produtodto.setCodBarras(produto.getCodBarras());
		produtodto.setDescricao(produto.getDescricao());
		produtodto.setDetalhe(produto.getDetalhe());
		produtodto.setPreco(produto.getPreco());
		produtodto.setPrecoDesconto(produto.getPrecoDesconto());
		produtodto.setDescontoPercentual(produto.getDescontoPercentual());
		produtodto.setQuantidade(produto.getQuantidade());
		produtodto.setCategoriaId(produto.getCategoria()!=null?produto.getCategoria().getId():null);
		produtodto.setCategoriaNome(produto.getCategoria()!=null?produto.getCategoria().getNome():null);
		return produtodto;
	}

	public static ProdutoDTO model2dto(Optional<Produto> produto) {
		return model2dto(produto.get());
	}
}
