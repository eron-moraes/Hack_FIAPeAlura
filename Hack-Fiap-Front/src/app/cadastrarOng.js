import { conectaApi } from "./conectaOng.js";

const formulario = document.querySelector("[data-formulario]");

async function criaCard(evento) {
  evento.preventDefault();

  const nomeONG = document.querySelector("[data-nome]").value;
  const cnpj = document.querySelector("[data-cnpj]").value;
  const senha = document.querySelector("[data-senha]").value;
  const tipoONG = document.querySelector("[data-tipo-ong]").value;
  const email = document.querySelector("[data-email]").value;

  try {
    await conectaApi.cadastrarONG(nomeONG, cnpj, senha, tipoONG, email);
    window.location.href = "./dashboard.html";
  } catch (e) {
    alert(e);
  }
}

formulario.addEventListener("submit", evento => criaCard(evento));