package br.com.hackfiapalura.grupoong.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ong")
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String atividadeDaOng;
    private String tipoDeFinanciamento;
    private String cnpj;

    public Ong() {
    }

    public Ong(Long id, String nome, String atividadeDaOng, String tipoDeFinanciamento, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.atividadeDaOng = atividadeDaOng;
        this.tipoDeFinanciamento = tipoDeFinanciamento;
        this.cnpj = cnpj;
    }
}

