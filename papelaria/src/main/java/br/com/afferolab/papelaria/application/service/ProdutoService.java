package br.com.afferolab.papelaria.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.afferolab.papelaria.application.dto.ProdutoDTO;
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

	public List<ProdutoDTO> produtos() {
		List<ProdutoDTO> produtos =new ArrayList<ProdutoDTO>();
		ProdutoDTO p1 =new ProdutoDTO();
		p1.setNome("creme dental");
		ProdutoDTO p2 =new ProdutoDTO();
		p2.setNome("desodorante");
		ProdutoDTO p3 =new ProdutoDTO();
		p3.setNome("gel lub KY");
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		//TODO:CRIAR UM TRADUTOR DE PRODUTO PRA PRODUTOdto
	//	return (List<Produto>) getprodutoRepository().findAll();
	 
		return produtos;
	}
	
	public Produto cadastrar(ProdutoDTO produtoDto) {
		//TODO:CRIAR UM TRADUTOR DE PRODUTOdto PRA PRODUTO
		Produto produto=new Produto();
		return getprodutoRepository().save(produto);
	}
	
	
	public void excluir(Long id) {
		 getprodutoRepository().delete(id);
	}
	public Produto buscarPorId(Long id) {
		return getprodutoRepository().findOne(id);
	}
	
	public boolean existe(Long id) {
		return getprodutoRepository().exists(id);
	}
	
}