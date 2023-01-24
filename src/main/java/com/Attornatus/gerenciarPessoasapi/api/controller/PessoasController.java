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
    PessoaService pessoaService;

    @Autowired
    EnderecoService enderecoService;

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

    @PostMapping("/{pessoaId}/enderecos")
    public ResponseEntity<Endereco> adicionaUmEndereco(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
        enderecoService.criaEnderecoPessoa(pessoaId, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{pessoaId}/enderecos")
    public List<Endereco> listaEnderecosDeUmaPessoa(@PathVariable Long pessoaId) {
        return pessoaService.listaEnderecosDePessoa(pessoaId);
    }

    @PutMapping("/{pessoaId}/enderecos")
    public List<Endereco> alteraEnderecoPrincipal(@PathVariable Long pessoaId, @RequestBody Endereco enderecoId ) {
        return enderecoService.alteraEnderecoPrincipal(pessoaId, enderecoId);
    }
}