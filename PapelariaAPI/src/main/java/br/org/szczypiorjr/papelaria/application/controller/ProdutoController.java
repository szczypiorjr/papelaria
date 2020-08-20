package br.org.szczypiorjr.papelaria.application.controller;


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

import br.org.szczypiorjr.papelaria.application.dto.ProdutoDTO;
import br.org.szczypiorjr.papelaria.application.service.CategoriaService;
import br.org.szczypiorjr.papelaria.application.service.ProdutoService;


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
	public void cadastrar(@Valid @RequestBody ProdutoDTO produtoNovo){
		
		getProdutoService().salvar(produtoNovo,this.categoriaService.getCategoriaRepository().findOne(produtoNovo.getCategoriaId()));
	}
	
	 @RequestMapping(value = "/produtos/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> excluir(@PathVariable(value = "id") long id){
		 System.out.println("excluir-> id  "+id);
		 
		  if(getProdutoService().existe(id)) {
			    	getProdutoService().excluir(id);
		            return new ResponseEntity<>(HttpStatus.OK);
		        }
		        else
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  	  }
	        	   

	 @RequestMapping(value = "/produtos/produto/{id}", method = RequestMethod.GET)
	    public ResponseEntity<ProdutoDTO> produto(@PathVariable(value = "id") long id)
	    {
		 ProdutoDTO produtoDTO= null;
		   if(getProdutoService().existe(id)) {
			   produtoDTO =  getProdutoService().buscarPorId(id);
			   return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
		   }	           
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	 @RequestMapping(value = "/produtos/atualizar", method =  RequestMethod.PUT)
	    public void atualizar(@Valid @RequestBody ProdutoDTO produtoAtualizado){
		 getProdutoService().salvar(produtoAtualizado,this.categoriaService.getCategoriaRepository().findOne(produtoAtualizado.getCategoriaId()));
	    }

}