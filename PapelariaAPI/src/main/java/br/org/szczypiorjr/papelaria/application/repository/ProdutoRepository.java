package br.org.szczypiorjr.papelaria.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.org.szczypiorjr.papelaria.application.model.Produto;

@Component
public interface ProdutoRepository  
extends CrudRepository<Produto, Long>
//extends JpaRepository<Usuario, Long>
{


}











