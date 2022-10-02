import "./styles.css";

import { Component } from "react";

export class ButtonCart extends Component {
  addCart({ numero }) {
    console.log(`numero ${numero}`);
  }

  render() {
    return (
      <button className="button" onClick={this.addCart}>
        Adicionar ao Carrinho
      </button>
    );
  }
}
