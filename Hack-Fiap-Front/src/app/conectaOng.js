async function listaEspecificaONG(ong) {
  const conexao = await fetch(`http://localhost:3000/ongs?id=${ong}`);
  const conexaoConvertida = await conexao.json();
  return conexaoConvertida;
}

async function listaONGs() {
  const conexao = await fetch(`http://localhost:3000/ongs`);
  const conexaoConvertida = await conexao.json();
  console.table(conexaoConvertida);
  return conexaoConvertida;
}

async function cadastrarONG(nomeONG, cnpj, senha, tipo, email, logo) {
  const conexao = await fetch('http://localhost:3000/ongs', {
    method: "POST",
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify({
      nomeONG: nomeONG,
      cnpj: cnpj,
      senha: senha,
      tipo: tipo,
      email: email,
      logo: logo
    })
  });

  const conexaoConvertida = await conexao.json();
  return conexaoConvertida;
}

export const conectaApi = {
  listaONGs,
  cadastrarONG,
  listaEspecificaONG,
}