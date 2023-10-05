package br.com.hackfiapalura.grupoong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.hackfiapalura.grupoong.domain.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {
   
}

