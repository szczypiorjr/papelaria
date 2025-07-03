package br.org.szczypiorjr.papelaria.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.org.szczypiorjr.papelaria.application.model.Categoria;

@Component
public interface CategoriaRepository  
extends CrudRepository<Categoria, Long>
//extends JpaRepository<Usuario, Long>
{


}











