async function listaONGs() {
  const conexao = await fetch(`http://localhost:3000/servicos`);
  const conexaoConvertida = await conexao.json();
  console.table(conexaoConvertida);
  return conexaoConvertida;
}

async function listaServicoEspecifico(id) {
  const conexao = await fetch(`http://localhost:3000/servicos/?id=${id}`);
  const conexaoConvertida = await conexao.json();
  console.table(conexaoConvertida);
  return conexaoConvertida;
}

async function cadastrarNecessidade(descricao, necessidades, idONG) {
  const conexao = await fetch('http://localhost:3000/servicos', {
    method: "POST",
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify({
      descricao: descricao,
      necessidades: necessidades,
      idONG: idONG,
    })
  });

  const conexaoConvertida = await conexao.json();
  return conexaoConvertida;
}


export const conectaApi = {
  cadastrarNecessidade,
  listaServicoEspecifico,
  listaONGs,
}