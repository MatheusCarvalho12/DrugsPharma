package br.com.api.drugspharmaapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.drugspharmaapi.modelo.ProdutoModelo;
import br.com.api.drugspharmaapi.modelo.RespostaModelo;
import br.com.api.drugspharmaapi.repositorio.ApiRepositorio;

@Service
public class APIcadastrar {

  @Autowired
  private ApiRepositorio pr;

  @Autowired
  private RespostaModelo rm;

  // Método para cadastrar ou alterar produtos
  public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String string) {

    try {
      if (pm.getName().equals("")) {
        rm.setMensagem("O nome do produto é obrigatório!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else if (pm.getImg().equals("")) {
        rm.setMensagem("A imagem do produto é obrigatória!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else if (pm.getStock() < 0) {
        rm.setMensagem("O estoque do produto é obrigatório!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else if (pm.getDescription().equals("")) {
        rm.setMensagem("A descrição do produto é obrigatória!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else if (pm.getPrice() == (0.0)) {
        rm.setMensagem("O preço do produto é obrigatório!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else if (pm.getId() < (0)) {
        rm.setMensagem("O id do produto é obrigatório!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else {
        if (string.equals("cadastrar")) {
          return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        } else {
          return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
        }
      }
    } catch (Exception e) {
      rm.setMensagem("Algo aconteceu errado!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    }

  }
}
