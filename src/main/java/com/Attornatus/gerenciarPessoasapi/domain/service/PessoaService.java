package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import com.Attornatus.gerenciarPessoasapi.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    public Pessoa validaIdPessoa(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
                () -> new IdNaoEncontradoException(
                        String.format("A pessoa com o ID %d, não foi encontrada", id)
                )
        );
    }

    public void salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}
