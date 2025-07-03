package br.org.szczypiorjr.papelaria.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void salvar(ProdutoDTO produtoDto,Optional<Categoria> optional ) {
					getprodutoRepository().save(ProdutoTradutor.dto2model((produtoDto.getId()==null?
							new Produto():getprodutoRepository().findById(produtoDto.getId()).get()),produtoDto,optional.get()));
	}
	
	public void excluir(Long id) {
		 getprodutoRepository().delete( getprodutoRepository().findById(id).get());
	}
	public ProdutoDTO buscarPorId(Long id) {
		return ProdutoTradutor.model2dto(getprodutoRepository().findById(id));
	}
	
	public boolean existe(Long id) {
		return getprodutoRepository().existsById(id);
	}
	
}