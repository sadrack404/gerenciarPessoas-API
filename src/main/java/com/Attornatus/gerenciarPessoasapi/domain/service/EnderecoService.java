package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

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

}
