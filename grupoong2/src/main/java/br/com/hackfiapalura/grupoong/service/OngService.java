package br.com.hackfiapalura.grupoong.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hackfiapalura.grupoong.domain.Ong;
import br.com.hackfiapalura.grupoong.repository.OngRepository;
import java.util.List;

@Service
public class OngService {
    private final OngRepository ongRepository;

    @Autowired
    public OngService(OngRepository ongRepository) {
        this.ongRepository = ongRepository;
    }

    public List<Ong> listarTodasAsOngs() {
        return ongRepository.findAll();
    }

    public Ong criarOng(Ong ong) {
        return ongRepository.save(ong);
    }

    public Ong buscarOngPorId(Long id) {
        return ongRepository.findById(id).orElse(null);
    }

    public Ong atualizarOng(Long id, Ong ong) {
        Ong ongExistente = buscarOngPorId(id);

        if (ongExistente != null) {
            ongExistente.setNome(ong.getNome());
            ongExistente.setAtividadeDaOng(ong.getAtividadeDaOng());
            ongExistente.setTipoDeFinanciamento(ong.getTipoDeFinanciamento());
            ongExistente.setCnpj(ong.getCnpj());

            return ongRepository.save(ongExistente);
        }

        return null;
    }

    public void excluirOng(Long id) {
        Ong ongExistente = buscarOngPorId(id);
        
        if (ongExistente != null) {
            ongRepository.delete(ongExistente);
        }
    }
}

