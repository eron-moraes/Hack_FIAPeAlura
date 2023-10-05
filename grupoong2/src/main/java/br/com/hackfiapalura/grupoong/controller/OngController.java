package br.com.hackfiapalura.grupoong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.hackfiapalura.grupoong.domain.Ong;
import br.com.hackfiapalura.grupoong.service.OngService;

@RestController
@RequestMapping("/ong")
public class OngController {
    private final OngService ongService;

    @Autowired
    public OngController(OngService ongService) {
        this.ongService = ongService;
    }

    @GetMapping("/ongs")
    public List<Ong> listarTodasAsOngs() {
        return ongService.listarTodasAsOngs();
    }

    @PostMapping("/ongs")
    public Ong criarOng(@RequestBody Ong ong) {
        return ongService.criarOng(ong);
    }

    @GetMapping("/ongs/{id}")
    public Ong buscarOngPorId(@PathVariable Long id) {
        return ongService.buscarOngPorId(id);
    }

    @PutMapping("/ongs/{id}")
    public Ong atualizarOng(@PathVariable Long id, @RequestBody Ong ong) {
        return ongService.atualizarOng(id, ong);
    }

    @DeleteMapping("/ongs/{id}")
    public void excluirOng(@PathVariable Long id) {
        ongService.excluirOng(id);
    }
}

