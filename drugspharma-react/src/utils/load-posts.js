export const loadPosts = async () => {
  const apiProdutos = fetch("https://localhost:8080/listar");

  const [produtos] = await Promise.all([apiProdutos]);

  const produtosJson = await produtos.json();

  const postsAndPhotos = produtosJson.map((post, index) => {
    return { ...post, cover: produtosJson[index].url };
  });

  return postsAndPhotos;
};
