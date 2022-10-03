import "./styles.css";
import { ButtonCart } from "../button";

export const PostCard = ({ name, img, description, price, id, stock }) => (
  <div class="cards">
    <div class="card">
      <div class="overlay">
        <ButtonCart id={id} name={name} img={img} price={price} stock={stock}/>
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
