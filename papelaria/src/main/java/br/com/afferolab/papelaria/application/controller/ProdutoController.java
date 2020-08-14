package br.com.afferolab.papelaria.application.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.afferolab.papelaria.application.dto.ProdutoDTO;


//TODO:RETIRAR TODAS AS REFERENCIAS ÁS ESTAS ENTIDADES ESTAS ENTIDADES SERÃO MANIPULADAS NAS CAMADAS ABAIXO
//AQUI SOMENTE DTOS
//TRATAR DE DTO PARA ENTIDADE E VICE VERSA NA CAMADA DE SERVICE---TRADUTOR
import br.com.afferolab.papelaria.application.model.Categoria;
import br.com.afferolab.papelaria.application.model.Produto;

import br.com.afferolab.papelaria.application.service.CategoriaService;
import br.com.afferolab.papelaria.application.service.ProdutoService;


@RestController
@Component
public class ProdutoController
{	
	@Autowired
	@Qualifier(value="produtoService")
	private ProdutoService produtoService;

	@Autowired
	@Qualifier(value="categoriaService")
	private CategoriaService categoriaService;
	

	public ProdutoController(){
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ProdutoDTO> produtos() {
		return getProdutoService().produtos();
	}

	@RequestMapping(value = "/produtos/cadastrar", method =  RequestMethod.POST)
	public ProdutoDTO cadastrar(@Valid @RequestBody ProdutoDTO produtoNovo){
		
	Categoria categoriaProduto =this.categoriaService.buscarPorId(produtoNovo.getCategoriaId());
	produtoNovo.setCategoriaId(categoriaProduto.getId());
	 getProdutoService().cadastrar(produtoNovo);
	return produtoNovo;
	}
	
	 @RequestMapping(value = "/produtos/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> excluir(@PathVariable(value = "id") long id)
	    {
		 System.out.println("excluir-> id  "+id);
		 
		  if(getProdutoService().existe(id)) {
			  Produto produto = getProdutoService().buscarPorId(id);
		        	getProdutoService().excluir(produto.getId());
		            return new ResponseEntity<>(HttpStatus.OK);
		        }
		        else
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  
		  }
	        	   

	 @RequestMapping(value = "/produtos/produto/{id}", method = RequestMethod.GET)
	    public ResponseEntity<ProdutoDTO> produto(@PathVariable(value = "id") long id)
	    {
		 Produto produto = null;
		 ProdutoDTO produtoDTO= null;
		   if(getProdutoService().existe(id)) {
			   produto =  getProdutoService().buscarPorId(id);
			   return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
		   }	           
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	/* @RequestMapping(value = "/produtos/atualizar/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Pessoa> atualizar(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa)
	    {
	        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
	        if(oldPessoa.isPresent()){
	            Pessoa pessoa = oldPessoa.get();
	            pessoa.setNome(newPessoa.getNome());
	            _pessoaRepository.save(pessoa);
	            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }*/

}