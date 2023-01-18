package com.Attornatus.gerenciarPessoasapi.domain.repository;

import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
