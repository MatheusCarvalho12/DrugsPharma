package br.com.api.drugspharmaapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.drugspharmaapi.modelo.ProdutoModelo;
import br.com.api.drugspharmaapi.modelo.RespostaModelo;
import br.com.api.drugspharmaapi.repositorio.ApiRepositorio;

@Service
public class ApiServico {

  @Autowired
  private ApiRepositorio pr;

  @Autowired
  private RespostaModelo rm;

  // Método para listar todos os produtos
  public Iterable<ProdutoModelo> listar() {
    return pr.findAll();
  }

  // Método para remover produtos
  public ResponseEntity<RespostaModelo> remover(long codigo) {

    pr.deleteById(codigo);

    rm.setMensagem("O produto foi removido com sucesso!");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

  }

}