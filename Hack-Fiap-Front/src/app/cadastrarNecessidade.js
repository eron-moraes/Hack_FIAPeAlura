import { conectaApi } from "./conectaNecessidades.js";
import { conectaApi as conectaONG } from "./conectaOng.js";

const formulario = document.querySelector("[data-formulario]");

async function criaCard(evento) {
  evento.preventDefault();

  const descricao = document.querySelector("[data-desc]").value;
  const necessidade = document.querySelector("[data-nesc]").value;
  const idONG = Number(document.querySelector("[data-ong]").value);

  console.table(await conectaONG.listaEspecificaONG(idONG));

  try {
    await conectaApi.cadastrarNecessidade(descricao, necessidade, idONG);
    window.location.href = "./dashboard.html";
  } catch (e) {
    alert(e);
  }
}

formulario.addEventListener("submit", evento => criaCard(evento));