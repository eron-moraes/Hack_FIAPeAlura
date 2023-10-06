async function listaUsers() {
  const conexao = await fetch('http://localhost:3000/users');
  const usersLista = await conexao.json();

  return usersLista;
}

async function estaCadastrado(email) {
  const conexao = await fetch(`http://localhost:3000/users?email=${email}`);
  const user = await conexao.json();
  
  if(user.length == 0) {
   return `
    <h2 class="mensagem__titulo">
      Nenhum usuario encontrado
    </h2>`;
}
  return user;
}

async function loginValidacao(email, senha) {
  const conexao = await fetch(`http://localhost:3000/users?email=${email}&senha=${senha}`);
  const user = await conexao.json();
  return user;
}

export const conectaApi = {
  listaUsers,
  estaCadastrado,
  loginValidacao,
}