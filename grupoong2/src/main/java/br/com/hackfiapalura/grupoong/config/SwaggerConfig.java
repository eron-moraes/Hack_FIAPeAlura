package br.com.hackfiapalura.grupoong.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
	
		
		@Value("${grupoong.openapi.dev-url}")
		public String devUrl;
		
		@Bean
		public OpenAPI myOpenAPI() {
			Server devServ = new Server();
			devServ.setUrl(devUrl);
			devServ.setDescription("URL de desenvolvimento");
			
			
			Contact contato = new Contact();
			contato.setEmail("grupoong@gmail.com");
			contato.setName("ong");
			contato.setUrl("Em Breve");
			
			Info info = new Info()
					.title("API do grupo ONG")
					.version("1.0")
					.contact(contato)
					.description("API para endpoints do grupo ONG do Hackathon FIAP + ALURA");
			
			return new OpenAPI()
					.info(info)
					.servers(List.of(devServ));
		}

}