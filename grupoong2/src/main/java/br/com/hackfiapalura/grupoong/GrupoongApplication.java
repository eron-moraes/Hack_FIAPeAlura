package br.com.hackfiapalura.grupoong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.hackfiapalura.grupoong.service.DBService;

@SpringBootApplication
public class GrupoongApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GrupoongApplication.class, args);

		// Obtém o serviço DBService do contexto Spring
		DBService dbService = context.getBean(DBService.class);

		// Chama o método para salvar o Talent no banco de dados
		dbService.inicializarBancoDeDados(); // Este método deve ser atualizado para aceitar um Talent como
												// parâmetro

	}
}