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
        Talent talent1 = new Talent(null, "Roberta", "Tocar piano", 25, "Ficar rica");
        Talent talent2 = new Talent(null, "Felipe", "Ser dev", 30, "Virar o melhor dev do planeta");
        Talent talent3 = new Talent(null, "Eron", "ser dev ruim", 28, "terminar esse codigo");
        Talent talent4 = new Talent(null, "Oliver", "ser ator", 27, "Comprar um hiat");

        talentRepository.save(talent1);
        talentRepository.save(talent2);
        talentRepository.save(talent3);
        talentRepository.save(talent4);

        Ong ong1 = new Ong(null, "ONG A", "Atividade A", "Financiamento A", "CNPJ A");
        Ong ong2 = new Ong(null, "ONG B", "Atividade B", "Financiamento B", "CNPJ B");

        ongRepository.save(ong1);
        ongRepository.save(ong2);
    }
}
