package br.org.szczypiorjr.papelaria.application.util;

import java.util.Optional;

import br.org.szczypiorjr.papelaria.application.dto.CategoriaDTO;
import br.org.szczypiorjr.papelaria.application.model.Categoria;

public class CategoriaTradutor {
	
	public static Categoria dto2model(CategoriaDTO categoriaDto) {
		Categoria categoria =new Categoria();
		categoria.setId(categoriaDto.getId());
		categoria.setNome(categoriaDto.getNome());
		return categoria; 
	}
	
	public static CategoriaDTO model2dto(Optional<Categoria> optional) {
		CategoriaDTO categoriaDto= new CategoriaDTO();
		categoriaDto.setId(optional.get().getId());
		categoriaDto.setNome(optional.get().getNome());
		return categoriaDto;
	}

	public static CategoriaDTO model2dto(Categoria categoria) {
		CategoriaDTO categoriaDto= new CategoriaDTO();
		categoriaDto.setId(categoria.getId());
		categoriaDto.setNome(categoria.getNome());
		return categoriaDto;
	}
}
