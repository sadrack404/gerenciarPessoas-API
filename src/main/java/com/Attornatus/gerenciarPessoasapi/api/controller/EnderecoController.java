package com.Attornatus.gerenciarPessoasapi.api.controller;

import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import com.Attornatus.gerenciarPessoasapi.domain.service.EnderecoService;
import com.Attornatus.gerenciarPessoasapi.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Endereco> nuscar(@PathVariable Long id) {
        return enderecoRepository.findById(id);
    }

    @PostMapping
    public Endereco criaEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }


}