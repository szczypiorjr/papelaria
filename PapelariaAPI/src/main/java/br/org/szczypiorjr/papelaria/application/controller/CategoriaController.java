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

import br.org.szczypiorjr.papelaria.application.dto.CategoriaDTO;
import br.org.szczypiorjr.papelaria.application.service.CategoriaService;


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
	public List<CategoriaDTO> categorias() {
		return getCategoriaService().categorias();
	}

	@RequestMapping(value = "/categorias/cadastrar", method =  RequestMethod.POST)
	public void cadastrar(@Valid @RequestBody CategoriaDTO categoriaNovo){
		 getCategoriaService().cadastrar(categoriaNovo);
	}
	
	 @RequestMapping(value = "/categorias/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> excluir(@PathVariable(value = "id") long id)
	    {
		 System.out.println("excluir-> id  "+id);
		 
		  if(getCategoriaService().existe(id)) {
			  CategoriaDTO categoriaDTO = getCategoriaService().buscarPorId(id);
		        	getCategoriaService().excluir(categoriaDTO.getId());
		            return new ResponseEntity<>(HttpStatus.OK);
		        }
		        else
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  
		  }
	        	   

	 @RequestMapping(value = "/categorias/categoria/{id}", method = RequestMethod.GET)
	    public ResponseEntity<CategoriaDTO> categoria(@PathVariable(value = "id") long id)
	    {
		 CategoriaDTO categoriaDTO = null;
		   if(getCategoriaService().existe(id)) {
			   categoriaDTO =  getCategoriaService().buscarPorId(id);
			   return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.OK);
		   }	           
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }


}