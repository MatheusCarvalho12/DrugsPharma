import { useState, useEffect } from "react";
import { Posts } from "./components/Posts";

import drugspharmalogovip from "./imgs/drugspharmalogovip.png";


function App() {
  // UseState
  const [Produtos, setProdutos] = useState([]);

  // UseEffect
  useEffect(() => {
    fetch("http://wsl.local:8080/listar")
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => setProdutos(retorno_convertido));
  }, []);

  //retorno
  return (
    <section className="container">
      <center>
        <img src={drugspharmalogovip} alt="DrugsPharma" />
      </center>
      <Posts posts={Produtos} />
    </section>
  );
}
export default App;
