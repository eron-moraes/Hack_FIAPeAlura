package br.com.hackfiapalura.grupoong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.hackfiapalura.grupoong.service.DBService;

@SpringBootApplication
public class GrupoongApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GrupoongApplication.class, args);

		
		DBService dbService = context.getBean(DBService.class);

		
		dbService.inicializarBancoDeDados(); 
	}
}