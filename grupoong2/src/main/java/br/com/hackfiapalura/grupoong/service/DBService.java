package br.com.hackfiapalura.grupoong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackfiapalura.grupoong.domain.Talent;
import br.com.hackfiapalura.grupoong.repository.TalentRepository;

@Service
public class DBService {

    private final TalentRepository talentRepository;

    @Autowired
    public DBService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public void inicializarBancoDeDados() {
        // Verifica se já existem dados no banco de dados
        if (talentRepository.count() == 0) {
            // Cria alguns talentos de exemplo com IDs e salva no banco de dados
            Talent talent1 = new Talent(1L, "Nome1", "Talento1", 25, "Objetivo1");
            Talent talent2 = new Talent(2L, "Nome2", "Talento2", 30, "Objetivo2");
            Talent talent3 = new Talent(3L, "Nome3", "Talento3", 28, "Objetivo3");

            talentRepository.save(talent1);
            talentRepository.save(talent2);
            talentRepository.save(talent3);
        }
    }
}
