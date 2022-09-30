package br.com.api.produtos.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelos.ProdutoModelo;
import br.com.api.produtos.modelos.RespostaModelo;
import br.com.api.produtos.repositório.ProdutoRepositorio;
import scala.collection.mutable.StringBuilder;

@Service
public class ProdutoServico {

  @Autowired
  private ProdutoRepositorio pr;

  @Autowired
  private RespostaModelo rm;

  // Método para listar todos os produtos
  public Iterable<ProdutoModelo> listar() {
    return pr.findAll();
  }

  // Método para cadastrar ou alterar produtos
  public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, StringBuilder acao) {

    if (pm.getName().equals("")) {
      rm.setMensagem("O nome do produto é obrigatório!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getImg().equals("")) {
      rm.setMensagem("A imagem do produto é obrigatória!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getDescription().equals("")) {
      rm.setMensagem("A descrição do produto é obrigatória!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getPrice() == (0.0)) {
      rm.setMensagem("O preço do produto é obrigatório!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getId() == (0)) {
      rm.setMensagem("O id do produto é obrigatório!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else {
      if (acao.equals("cadastrar")) {
        return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
      } else {
        return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
      }
    }
  }

  // Método para remover produtos
  public ResponseEntity<RespostaModelo> remover(long codigo) {

    pr.deleteById(codigo);

    rm.setMensagem("O produto foi removido com sucesso!");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

  }

}