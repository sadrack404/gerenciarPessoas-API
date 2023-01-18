package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa validaIdPessoa(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
                () -> new IdNaoEncontradoException(
                        String.format("A pessoa com o ID %d, não foi encontrada", id)
                )
        );
    }

    public Pessoa salvar(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }

}
