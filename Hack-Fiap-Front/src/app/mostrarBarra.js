import { conectaApi } from './conectaNecessidades.js';
import { conectaApi as conectaONG } from "./conectaOng.js";

const barra = document.querySelector('[data-ong-barra]');
const ongImg = barra.querySelector('[data-ong-img]');
const ongNome = barra.querySelector('[data-ong-nome]');
const ongCategoria = barra.querySelector('[data-ong-categoria]');
const ongDesc = barra.querySelector('[data-ong-desc]');
const ongNesc = barra.querySelector('[data-ong-nesc]');
const ondIdVoluntario = barra.querySelector('[data-ong-id-voluntario]');

async function populaBarra(id, idONG) {
  const ong = await conectaONG.listaEspecificaONG(idONG);
  const idServico = await conectaApi.listaServicoEspecifico(id);

  // console.log(idONG)
  console.log(ong)
  console.log(idServico[0])

  ongImg.src = ong[0].logo;
  ongNome.textContent = ong[0].nomeONG;
  ongCategoria.textContent = ong[0].tipo;
  ongDesc.textContent = idServico[0].descricao;
  ongNesc.textContent = idServico[0].necessidades;
  ondIdVoluntario.dataset.idOng = ong[0].ongId;

}

export const conectaBarra = {
  populaBarra
};