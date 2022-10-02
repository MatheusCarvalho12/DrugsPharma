import "./styles.css";

import { PostCard } from "../PostCard";

export const Posts = ({ posts }) => (
  <div className="posts">
    {posts.map((post) => (
      <PostCard
        id={post.id}
        name={post.name}
        description={post.description}
        price={post.price}
        img={post.img}
      />
    ))}
  </div>
);
      