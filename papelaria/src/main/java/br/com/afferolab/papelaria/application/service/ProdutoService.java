package br.com.afferolab.papelaria.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.afferolab.papelaria.application.model.Produto;
import br.com.afferolab.papelaria.application.repository.ProdutoRepository;

@Service
@Component
public class ProdutoService {

	@Autowired
	@Qualifier(value="produtoRepository")
	private ProdutoRepository produtoRepository;

	public ProdutoService(){
	}

	public ProdutoService(ProdutoRepository produtoRepository ) {
		this.produtoRepository=produtoRepository;
	}	

	public ProdutoRepository getprodutoRepository() {
		return produtoRepository;
	}

	public void setprodutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> listarTodos() {
		return (List<Produto>) getprodutoRepository().findAll();
	}
	
	public Produto cadastrar(Produto produto) {
		return getprodutoRepository().save(produto);
	}
}