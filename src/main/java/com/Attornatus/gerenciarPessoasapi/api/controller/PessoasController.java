package com.Attornatus.gerenciarPessoasapi.api.controller;

import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.PessoaRepository;
import com.Attornatus.gerenciarPessoasapi.domain.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @GetMapping()
    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa listaUmaPessoa(@PathVariable Long id) {
        return pessoaService.validaIdPessoa(id);
    }

    @PostMapping()
    public void criarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.salvar(pessoa);
    }

}