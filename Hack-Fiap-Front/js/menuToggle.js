const menuBotao = document.querySelector('[data-menu]');
const menuBarra = document.querySelector('[data-menu-barra]')

menuBotao.addEventListener('click', () => {
  document.documentElement.classList.toggle('barra--ativa');
  menuBarra.classList.toggle('menu__barra--ativo');
});

document.documentElement.onclick = function(event){
  if(event.target === document.documentElement){
    document.documentElement.classList.toggle('barra--ativa');
    menuBarra.classList.toggle('menu__barra--ativo');
  };
};