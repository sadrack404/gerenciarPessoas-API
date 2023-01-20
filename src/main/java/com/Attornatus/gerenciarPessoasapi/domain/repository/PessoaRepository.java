package com.Attornatus.gerenciarPessoasapi.domain.repository;

import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
