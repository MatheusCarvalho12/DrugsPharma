package br.com.api.produtos.repositório;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelos.ProdutoModelo;

@Repository

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {

}