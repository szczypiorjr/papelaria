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

//TODO:RETIRAR TODAS AS REFERENCIAS ÁS ESTAS ENTIDADES ESTAS ENTIDADES SERÃO MANIPULADAS NAS CAMADAS ABAIXO
//AQUI SOMENTE DTOS
//TRATAR DE DTO PARA ENTIDADE E VICE VERSA NA CAMADA DE SERVICE---TRADUTOR
import br.com.afferolab.papelaria.application.model.Categoria;

import br.com.afferolab.papelaria.application.service.CategoriaService;


@RestController
@Component
public class CategoriaController
{	
	@Autowired
	@Qualifier(value="categoriaService")
	private CategoriaService categoriaService;


	public CategoriaController(){
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@RequestMapping(value = "/categorias", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Categoria> categorias() {
		return getCategoriaService().categorias();
	}

	@RequestMapping(value = "/categorias/cadastrar", method =  RequestMethod.POST)
	public Categoria cadastrar(@Valid @RequestBody Categoria categoriaNovo){
		return getCategoriaService().cadastrar(categoriaNovo);
	}
	
	 @RequestMapping(value = "/categorias/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> excluir(@PathVariable(value = "id") long id)
	    {
		 System.out.println("excluir-> id  "+id);
		 
		  if(getCategoriaService().existe(id)) {
			  Categoria categoria = getCategoriaService().buscarPorId(id);
		        	getCategoriaService().excluir(categoria.getId());
		            return new ResponseEntity<>(HttpStatus.OK);
		        }
		        else
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  
		  }
	        	   

	 @RequestMapping(value = "/categorias/categoria/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Categoria> categoria(@PathVariable(value = "id") long id)
	    {
		 Categoria categoria = null;
		   if(getCategoriaService().existe(id)) {
			   categoria =  getCategoriaService().buscarPorId(id);
			   return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		   }	           
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }


}