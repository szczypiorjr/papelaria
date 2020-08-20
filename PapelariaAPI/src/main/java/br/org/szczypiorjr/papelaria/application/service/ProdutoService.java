package br.org.szczypiorjr.papelaria.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.org.szczypiorjr.papelaria.application.dto.ProdutoDTO;
import br.org.szczypiorjr.papelaria.application.model.Categoria;
import br.org.szczypiorjr.papelaria.application.model.Produto;
import br.org.szczypiorjr.papelaria.application.repository.ProdutoRepository;
import br.org.szczypiorjr.papelaria.application.util.ProdutoTradutor;

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
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		List<Produto> produtos       = new ArrayList<Produto>();
			
	 produtos =	((List<Produto>) getprodutoRepository().findAll());
		
	 produtos.forEach(produto->produtosDTO.add(ProdutoTradutor.model2dto(produto)));	
	 
	return produtosDTO;
	}
	
	public void salvar(ProdutoDTO produtoDto,Categoria categoriaProduto ) {
		//			produto=ProdutoTradutor.dto2model(produto,produtoDto,categoriaProduto);
		//    	    getprodutoRepository().save(produto);
					getprodutoRepository().save(ProdutoTradutor.dto2model((produtoDto.getId()==null?new Produto():getprodutoRepository().findOne(produtoDto.getId())),produtoDto,categoriaProduto));
	}
	
	public void excluir(Long id) {
		 getprodutoRepository().delete( getprodutoRepository().findOne(id).getId());
	}
	public ProdutoDTO buscarPorId(Long id) {
		return ProdutoTradutor.model2dto(getprodutoRepository().findOne(id));
	}
	
	public boolean existe(Long id) {
		return getprodutoRepository().exists(id);
	}
	
}