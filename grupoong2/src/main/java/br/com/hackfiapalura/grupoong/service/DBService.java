package br.com.hackfiapalura.grupoong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hackfiapalura.grupoong.domain.Talent;
import br.com.hackfiapalura.grupoong.repository.TalentRepository;
import br.com.hackfiapalura.grupoong.domain.Ong;
import br.com.hackfiapalura.grupoong.repository.OngRepository;

@Service
public class DBService {
    private final TalentRepository talentRepository;
    private final OngRepository ongRepository;

    @Autowired
    public DBService(TalentRepository talentRepository, OngRepository ongRepository) {
        this.talentRepository = talentRepository;
        this.ongRepository = ongRepository;
    }

    public void inicializarBancoDeDados() {
        Talent talent1 = new Talent(null, "Roberta", "Negócios", 25, "Ajudar pessoas");
        Talent talent2 = new Talent(null, "Felipe", "Desenvolvedor", 30, "Programar melhor");
        Talent talent3 = new Talent(null, "Eron", "Desenvolvedor", 28, "Horas para a faculdade");
        Talent talent4 = new Talent(null, "Oliver", "Negócios", 27, "Ganhar espaço no mercado de trabalho");

        talentRepository.save(talent1);
        talentRepository.save(talent2);
        talentRepository.save(talent3);
        talentRepository.save(talent4);

        Ong ong1 = new Ong(null, "ONG dos Musicos", "Ensino da Música", "Financiamento A", "12.123.456/0001-10");
        Ong ong2 = new Ong(null, "ONG dos desenvolvedores", "Ensino de programação", "Financiamento B", "23.456.789/0001-20");
        Ong ong3 = new Ong(null, "ONG dos navegadores", "Ensino de navegação", "Financiamento C", "23.456.789/0001-30");

        ongRepository.save(ong1);
        ongRepository.save(ong2);
        ongRepository.save(ong3);
    }
}
