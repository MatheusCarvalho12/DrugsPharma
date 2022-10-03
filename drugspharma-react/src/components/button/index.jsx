import "./styles.css";
export function ButtonCart(id) {
  function addCart({ id, name, price, img, stock }) {
    alert(`possui ${stock} items no estoque`);
  }

  return (
    <button className="button" onClick={() => addCart(id)}>
      ver informações do produto
    </button>
  );
}
