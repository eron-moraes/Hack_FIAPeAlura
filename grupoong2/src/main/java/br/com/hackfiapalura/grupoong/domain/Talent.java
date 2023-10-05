package br.com.hackfiapalura.grupoong.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "talent")
public class Talent {	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String talento;
    private int idade;
    private String objetivo;
    
	public Talent() {

	}
    
    
	public Talent(Long id, String nome, String talento, int idade, String objetivo) {
		this.id = id;
		this.nome = nome;
		this.talento = talento;
		this.idade = idade;
		this.objetivo = objetivo;
	}



    
    
}
