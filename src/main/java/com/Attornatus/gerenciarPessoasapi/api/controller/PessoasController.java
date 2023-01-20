package com.Attornatus.gerenciarPessoasapi.api.controller;

import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.service.EnderecoService;
import com.Attornatus.gerenciarPessoasapi.domain.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    PessoaService pessoaService;

    @GetMapping()
    public List<Pessoa> listar() {
        return pessoaService.listarTodasPessoas();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return pessoaService.validaIdPessoa(id);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa) {
        pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa PessoaNovo = pessoaService.validaIdPessoa(id);
        if (PessoaNovo != null) {
            BeanUtils.copyProperties(pessoa, PessoaNovo, "id");
            pessoaService.salvar(PessoaNovo);
            return ResponseEntity.ok(PessoaNovo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Endereco> adicionaUmEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        enderecoService.criaEnderecoPessoa(id, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/enderecos/{id}")
    public List<Endereco> listaEnderecosDeUmaPessoa(@PathVariable Long id) {
        return pessoaService.listaEnderecosDePessoa(id);
    }
}