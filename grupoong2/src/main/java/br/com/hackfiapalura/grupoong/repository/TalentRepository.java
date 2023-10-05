package br.com.hackfiapalura.grupoong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackfiapalura.grupoong.domain.Talent;

public interface TalentRepository extends JpaRepository<Talent, Long> {
	
	
}

