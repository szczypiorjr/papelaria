package br.com.afferolab.papelaria.application.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.afferolab.papelaria.application.model.Produto;
import br.com.afferolab.papelaria.application.service.ProdutoService;


@RestController
@Component
public class ProdutoController
{	
	@Autowired
	@Qualifier(value="produtoService")
	private ProdutoService produtoService;
	
	
	public ProdutoController(){
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}
	
	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@RequestMapping(value = "/produtos/todos", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Produto> listarTodos() {
		return getProdutoService().listarTodos();
	}
	
	/*@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST, produces = "application/json")
	public String save(Model model, @ModelAttribute("produto") Produto produtoNovo) {
		try {
			System.out.println(produtoNovo.getDescricao());
			System.out.println(produtoNovo.getCategoria());
			System.out.println(produtoNovo.getCodBarras());
			
			getProdutoService().cadastrar(produtoNovo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "save";
	}*/
	
	 @RequestMapping(value = "/produtos/novo", method =  RequestMethod.POST)
	    public Produto Post(@Valid @RequestBody Produto produtoNovo)
	    {
		 System.out.println(produtoNovo.getDescricao());
			System.out.println(produtoNovo.getCategoria());
			System.out.println(produtoNovo.getCodBarras());
	        return getProdutoService().cadastrar(produtoNovo);
	    }
	
	
}