package br.com.afferolab.papelaria.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.afferolab.papelaria.application.model.Categoria;
import br.com.afferolab.papelaria.application.repository.CategoriaRepository;

@Service
@Component
public class CategoriaService {

	@Autowired
	@Qualifier(value="categoriaRepository")
	private CategoriaRepository categoriaRepository;

	public CategoriaService(){
	}

	public CategoriaService(CategoriaRepository categoriaRepository ) {
		this.categoriaRepository=categoriaRepository;
	}	

	public CategoriaRepository getCategoriaRepository() {
		return categoriaRepository;
	}

	public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> categorias() {
		return (List<Categoria>) getCategoriaRepository().findAll();
	}
	
	public Categoria cadastrar(Categoria categoria) {
		return getCategoriaRepository().save(categoria);
	}
	
	
	public void excluir(Long id) {
		 getCategoriaRepository().delete(id);
	}
	public Categoria buscarPorId(Long id) {
		return getCategoriaRepository().findOne(id);
	}
	
	public boolean existe(Long id) {
		return getCategoriaRepository().exists(id);
	}
	
}