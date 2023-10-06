const ongBoxs = document.querySelectorAll('[data-ong]');
const ongBarra = document.querySelector('[data-ong-barra]')

ongBoxs.forEach(ong => {
  ong.addEventListener('click', () => {
    document.documentElement.classList.toggle('barra--ativa');
    ongBarra.classList.toggle('menu__barra--alt--ativo');
  });
});

document.documentElement.onclick = function (event) {
  if (event.target === document.documentElement) {
    document.documentElement.classList.toggle('barra--ativa');
    ongBarra.classList.toggle('menu__barra--alt--ativo');
  };
};