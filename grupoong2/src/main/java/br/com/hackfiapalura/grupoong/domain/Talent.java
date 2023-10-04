package br.com.hackfiapalura.grupoong.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    
	public Talent(Long id, String nome, String talento, int idade, String objetivo) {
		super();
		this.id = id;
		this.nome = nome;
		this.talento = talento;
		this.idade = idade;
		this.objetivo = objetivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTalento() {
		return talento;
	}

	public void setTalento(String talento) {
		this.talento = talento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
    
	
	
}

