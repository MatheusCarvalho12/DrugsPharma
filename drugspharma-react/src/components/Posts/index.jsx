import "./styles.css";

import { PostCard } from "../PostCard";

export const Posts = ({ posts }) => (
  <div className="posts">
    {posts.map((post, index) => (
      <PostCard
        id={index+1}
        name={post.name}
        description={post.description}
        price={post.price}
        img={post.img}
        stock={post.stock}
      />
    ))}
  </div>
);
      