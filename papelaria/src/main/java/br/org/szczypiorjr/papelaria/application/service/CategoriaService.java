package br.org.szczypiorjr.papelaria.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.org.szczypiorjr.papelaria.application.dto.CategoriaDTO;
import br.org.szczypiorjr.papelaria.application.model.Categoria;
import br.org.szczypiorjr.papelaria.application.repository.CategoriaRepository;
import br.org.szczypiorjr.papelaria.application.util.CategoriaTradutor;

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

	public List<CategoriaDTO> categorias() {
		List<CategoriaDTO> categorias =new ArrayList<CategoriaDTO>();
        ((List<Categoria>) this.categoriaRepository.findAll()).forEach(categoria->categorias.add(CategoriaTradutor.model2dto(categoria)));	
		return categorias;
	}
	
	public void cadastrar(CategoriaDTO categoriaDTO) {
		 getCategoriaRepository().save(CategoriaTradutor.dto2model(categoriaDTO));
	}
	
	
	public void excluir(Long id) {
		 getCategoriaRepository().deleteById(id);
	}
	public CategoriaDTO buscarPorId(Long id) {
		return CategoriaTradutor.model2dto(getCategoriaRepository().findById(id));
	}
	
	public boolean existe(Long id) {
		return getCategoriaRepository().existsById(id);
	}
	
}