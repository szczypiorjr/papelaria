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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.szczypiorjr.papelaria.application.dto.ProdutoDTO;
import br.org.szczypiorjr.papelaria.application.service.CategoriaService;
import br.org.szczypiorjr.papelaria.application.service.ProdutoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/produto")
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

	@GetMapping(value = "/produtos")
	@ResponseBody
	public List<ProdutoDTO> produtos() {
		return getProdutoService().produtos();
	}

	@PostMapping(value = "/produtos/cadastrar")
	public void cadastrar(@Valid @RequestBody ProdutoDTO produtoNovo){

		getProdutoService().salvar(produtoNovo,this.categoriaService.getCategoriaRepository().findById(produtoNovo.getCategoriaId()));
	}

	@DeleteMapping(value = "/produtos/excluir/{id}")
	public ResponseEntity<Object> excluir(@PathVariable(value = "id") long id){
		System.out.println("excluir-> id  "+id);

		if(getProdutoService().existe(id)) {
			getProdutoService().excluir(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@GetMapping(value = "/produtos/produto/{id}")
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

	@PutMapping(value = "/produtos/atualizar")
	public void atualizar(@Valid @RequestBody ProdutoDTO produtoAtualizado){
		getProdutoService().salvar(produtoAtualizado,this.categoriaService.getCategoriaRepository().findById(produtoAtualizado.getCategoriaId()));
	}

}