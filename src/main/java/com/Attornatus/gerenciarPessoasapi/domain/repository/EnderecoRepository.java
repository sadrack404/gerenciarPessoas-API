package com.Attornatus.gerenciarPessoasapi.domain.repository;

import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
