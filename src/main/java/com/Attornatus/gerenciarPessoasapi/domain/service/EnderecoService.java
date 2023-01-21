package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PessoaService pessoaService;
    private static List<Endereco> enderecos;

    public Endereco validaEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(
                () -> new IdNaoEncontradoException(
                        String.format("O Endereco com o ID %d, não foi encontrado", id)
                )
        );
    }

    @Transactional
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public Pessoa criaEnderecoPessoa(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        var pessoa = pessoaService.validaIdPessoa(pessoaId);
        if (pessoa != null) {
            pessoa.addEndereco(endereco);
            salvar(endereco);
        }
        return pessoa;
    }

    public void alteraEnderecoPrincipal(@PathVariable Long pessoaId, @RequestBody Long enderecoId) {
        var pessoa = pessoaService.validaIdPessoa(pessoaId);
        Boolean troca = false;
        if (pessoa != null) {
            enderecos = pessoa.getEnderecos();
            enderecos.stream()
                    .filter(Endereco::getEnderecoPrincipal)
                    .forEach(endereco -> endereco.setEnderecoPrincipal(troca));
        }
    }
}