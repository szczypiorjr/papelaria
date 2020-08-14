package br.com.afferolab.papelaria.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.afferolab.papelaria.application.model.Categoria;

@Component
public interface CategoriaRepository  
extends CrudRepository<Categoria, Long>
//extends JpaRepository<Usuario, Long>
{


}











