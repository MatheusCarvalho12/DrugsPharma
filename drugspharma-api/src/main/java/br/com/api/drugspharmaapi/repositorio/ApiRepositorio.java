package br.com.api.drugspharmaapi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.drugspharmaapi.modelo.ProdutoModelo;

@Repository

public interface ApiRepositorio extends CrudRepository<ProdutoModelo, Long> {

}