package br.com.hackfiapalura.grupoong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import br.com.hackfiapalura.grupoong.domain.Talent;
import br.com.hackfiapalura.grupoong.service.DBService;

import java.util.Scanner;

@SpringBootApplication
public class GrupoongApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GrupoongApplication.class, args);

		// Obtém o serviço DBService do contexto Spring
		DBService dbService = context.getBean(DBService.class);

		// Cria um Scanner para ler a entrada do usuário
		Scanner scanner = new Scanner(System.in);

		boolean sair = false;
		while (!sair) {
			// Exibe o menu principal
			System.out.println("Menu Principal:");
			System.out.println("1. Cadastrar um Talent");
			System.out.println("2. Sair");

			// Lê a escolha do usuário
			System.out.print("Escolha uma opção: ");
			int escolha = Integer.parseInt(scanner.nextLine());

			switch (escolha) {
			case 1:
				// Solicita ao usuário que digite os atributos do Talent
				System.out.println("Digite os atributos do Talent:");
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.print("Talento: ");
				String talento = scanner.nextLine();
				System.out.print("Idade: ");
				int idade = Integer.parseInt(scanner.nextLine());
				System.out.print("Objetivo: ");
				String objetivo = scanner.nextLine();

				// Cria um novo Talent com os atributos digitados
				Talent novoTalent = new Talent(null, nome, nome, idade, nome);
				novoTalent.setNome(nome);
				novoTalent.setTalento(talento);
				novoTalent.setIdade(idade);
				novoTalent.setObjetivo(objetivo);

				// Chama o método para salvar o Talent no banco de dados
				dbService.inicializarBancoDeDados(); // Este método deve ser atualizado para aceitar um Talent como
														// parâmetro

				// Imprime uma mensagem para indicar que o Talent foi cadastrado
				System.out.println("Talent cadastrado com sucesso!");
				break;
			case 2:
				sair = true; // Define sair como true para encerrar o loop
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

		// Fecha o Scanner
		scanner.close();
	}
}
