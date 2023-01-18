package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaService pessoaService;
    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Endereco validaIdEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(
                () -> new IdNaoEncontradoException(
                        String.format("O Endereço com o ID %d, não foi encontrado", id)
                )
        );
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Pessoa criaEnderecoPessoa(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        Pessoa pessoa = pessoaService.validaIdPessoa(pessoaId);
        if (pessoa != null) {
            pessoa.addEndereco(endereco);
            salvar(endereco);
        }
        return pessoa;
    }

}
