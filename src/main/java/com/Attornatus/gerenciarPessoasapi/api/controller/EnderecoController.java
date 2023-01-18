package com.Attornatus.gerenciarPessoasapi.api.controller;

import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import com.Attornatus.gerenciarPessoasapi.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listaEnderecos() {
        return enderecoRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Endereco> listaUmEndereco(Long id) {
        return enderecoRepository.findById(id);
    }

    @PostMapping
    public Endereco criaEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

}
