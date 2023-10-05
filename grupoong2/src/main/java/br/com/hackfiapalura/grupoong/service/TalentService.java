package br.com.hackfiapalura.grupoong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hackfiapalura.grupoong.domain.Talent;
import br.com.hackfiapalura.grupoong.repository.TalentRepository;

@Service
public class TalentService {
	private final TalentRepository talentRepository;

	@Autowired
	public TalentService(TalentRepository talentRepository) {
		this.talentRepository = talentRepository;
	}

	public List<Talent> listarTodosOsTalentos() {
		return talentRepository.findAll();
	}

	public Talent criarTalento(Talent talent) {
		return talentRepository.save(talent);
	}

	public Talent buscarTalentoPorId(Long id) {
		return talentRepository.findById(id).orElse(null);
	}

	public Talent atualizarTalento(Long id, Talent talent) {
		Talent talentoExistente = buscarTalentoPorId(id);

		talentoExistente.setNome(talent.getNome());
		talentoExistente.setTalento(talent.getTalento());
		talentoExistente.setIdade(talent.getIdade());
		talentoExistente.setObjetivo(talent.getObjetivo());

		return talentRepository.save(talentoExistente);
	}

	public void excluirTalento(Long id) {
		Talent talentoExistente = buscarTalentoPorId(id);
		talentRepository.delete(talentoExistente);
	}
}
