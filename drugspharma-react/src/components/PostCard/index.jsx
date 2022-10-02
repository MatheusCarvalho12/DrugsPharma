import "./styles.css";

export const PostCard = ({ name, img, description, price }) => (
  <div class="cards">
    <div class="card">
      <div class="overlay">
        <button class="button">Adicionar ao Carrinho</button>
      </div>
      <div class="image">
        <img src={img} alt={name} />
      </div>
      <div class="details">
        <div class="name">
          {name}
          <div class="description">{description}</div>
        </div>
        <div class="price">R${price}</div>
      </div>
    </div>
  </div>
);
