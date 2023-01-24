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
    private List<Endereco> enderecos;

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
    public Pessoa criaEnderecoPessoa(Long pessoaId, Endereco endereco) {
        var pessoa = pessoaService.validaIdPessoa(pessoaId);
        if (pessoa != null) {
            pessoa.addEndereco(endereco);
            salvar(endereco);
        }
        return pessoa;
    }

    public List<Endereco> alteraEnderecoPrincipal(Long pessoaId, Endereco enderecoId) {
        var pessoa = pessoaService.validaIdPessoa(pessoaId);
        if (pessoa != null) {
            enderecos = pessoa.getEnderecos();
            for ( Endereco end : enderecos ) {
                end.setEnderecoPrincipal(false);
                if (end.getId().equals(enderecoId.getId())){
                    end.setEnderecoPrincipal(true);
                }
            }
            pessoaService.salvar(pessoa);
            return enderecos;
        }
        return enderecos;
    }
}