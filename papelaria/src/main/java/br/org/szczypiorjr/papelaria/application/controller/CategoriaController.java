package br.org.szczypiorjr.papelaria.application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.szczypiorjr.papelaria.application.dto.CategoriaDTO;
import br.org.szczypiorjr.papelaria.application.service.CategoriaService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/categoria")
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

	@GetMapping("/categorias")
	@ResponseBody
	public List<CategoriaDTO> categorias() {
		return getCategoriaService().categorias();
	}

	@PostMapping(value = "/categorias/cadastrar")
	public void cadastrar(@Valid @RequestBody CategoriaDTO categoriaNovo){
		 getCategoriaService().cadastrar(categoriaNovo);
	}
	
	 @DeleteMapping(value = "/categorias/excluir/{id}")
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
	        	   

	    @GetMapping(value = "/categorias/categoria/{id}")
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