package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PessoaService pessoaService;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Pessoa criaEnderecoPessoa(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        var pessoa = pessoaService.validaIdPessoa(pessoaId);
        if (pessoa != null) {
            pessoa.addEndereco(endereco);
            salvar(endereco);
        }
        return pessoa;
    }
}