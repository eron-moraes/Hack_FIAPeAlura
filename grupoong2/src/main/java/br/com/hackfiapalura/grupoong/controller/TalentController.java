package br.com.hackfiapalura.grupoong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.hackfiapalura.grupoong.domain.Talent;
import br.com.hackfiapalura.grupoong.service.TalentService;

@RestController
@RequestMapping("/talent")
public class TalentController {
    private final TalentService talentService;

    @Autowired
    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }

    
    @GetMapping("/talentos")
    public List<Talent> listarTodosOsTalentos() {
        return talentService.listarTodosOsTalentos();
    }
    
    @PostMapping("/talentos")
    public Talent criarTalento(@RequestBody Talent talent) {
        return talentService.criarTalento(talent);
    }
    
    @GetMapping("/talentos/{id}")
    public Talent buscarTalentoPorId(@PathVariable Long id) {
        return talentService.buscarTalentoPorId(id);
    }
    
    @PutMapping("/talentos/{id}")
    public Talent atualizarTalento(@PathVariable Long id, @RequestBody Talent talent) {
        return talentService.atualizarTalento(id, talent);
    }
    
    @DeleteMapping("/talentos/{id}")
    public void excluirTalento(@PathVariable Long id) {
        talentService.excluirTalento(id);
    }

}
