package br.com.hackfiapalura.grupoong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.hackfiapalura.grupoong.service.DBService;

@SpringBootApplication
public class GrupoongApplication {

    private final DBService dbService;

    public GrupoongApplication(DBService dbService) {
        this.dbService = dbService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GrupoongApplication.class, args);
    }


}