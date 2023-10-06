import { conectaApi } from "./conectaUsers.js";

const formulario = document.querySelector('[data-formulario]');
const camposFormulaio = formulario.querySelectorAll('[data-campo]');


formulario.addEventListener('submit', async (e) => {
  const listaRespostas = {
    'cpfForm': e.target.cpf.value,
    'senhaForm': e.target.senha.value,
  }
  
  e.preventDefault();

  await verificaLogin(listaRespostas.cpfForm, listaRespostas.senhaForm);
});

camposFormulaio.forEach(campo => {
  campo.addEventListener('blur', async () => {
    await verificaCampo(campo);
  });
  campo.addEventListener('invalid', (e) => {
    e.preventDefault();
  });
});

const tiposDeErros = [
  'valueMissing',
  'typeMismatch',
  'tooShort',
  'customError'
]

const mensagens = {
  email: {
    valueMissing: "O campo de e-mail não pode estar vazio.",
    tooShort: "Por favor, preencha um e-mail válido.",
    typeMismatch: "Por favor, preencha um e-mail válido. Ex: email@contato.com",
    customError: "Nenhum correspondente encontrado",
  },
  senha: {
    valueMissing: "O campo de senha não pode estar vazio.",
    tooShort: "Por favor, preencha um senha válido.",
    customError: "Senha não corresponde com o e-mail",
  }
}

async function verificaCampo(campo) {
  let mensagem = '';
  campo.setCustomValidity('');

  tiposDeErros.forEach(erro => {
    if (campo.validity[erro]) {
      mensagem = mensagens[campo.name][erro];
    }
  })

  const mensagemErro = campo.parentNode.querySelector('[data-mensagem-erro]')
  let validadorDeInput = campo.checkValidity();

  if (validadorDeInput) {
    if (campo.name == 'email') {
      await verificaExisteEmail(campo);
      mensagem = mensagens[campo.name]['customError'];
      validadorDeInput = campo.checkValidity();
    };
  };

  if (!validadorDeInput) {
    mensagemErro.textContent = mensagem;
  } else {
    mensagemErro.textContent = '';
  }
}

async function verificaExisteEmail(campo) {
  const userExsite = await conectaApi.estaCadastrado(campo.value);
  if (!Array.isArray(userExsite)) {
    campo.setCustomValidity('Esse e-mail não está cadastrado');
  }
}

async function verificaLogin(emailBusca, senha) {
  try {
    const user = await conectaApi.loginValidacao(emailBusca, senha);

    if (user.length <= 0) {
      throw new Error('E-mail e senha não correspondem');
    }

    const { nome, email, idGastos } = user[0];

    const userData = {
      nome,
      email,
      idGastos
    }

    localStorage.setItem("userLogado", JSON.stringify(userData));

    window.location.href = "dashboard.html";

  } catch (erro) {
    // const mensagemErro = document.querySelector('[data-mensagem-erro-login]');
    // mensagemErro.textContent = erro;
  }

}