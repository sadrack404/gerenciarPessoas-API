package com.Attornatus.gerenciarPessoasapi.domain.service;

import com.Attornatus.gerenciarPessoasapi.domain.exception.IdNaoEncontradoException;
import com.Attornatus.gerenciarPessoasapi.domain.model.Endereco;
import com.Attornatus.gerenciarPessoasapi.domain.model.Pessoa;
import com.Attornatus.gerenciarPessoasapi.domain.repository.EnderecoRepository;
import com.Attornatus.gerenciarPessoasapi.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    private static List <Endereco> enderecos;

    public List<Pessoa> listarTodasPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa validaIdPessoa(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
                () -> new IdNaoEncontradoException(
                        String.format("A pessoa com o ID %d, não foi encontrada", id)
                )
        );
    }
    @Transactional
    public void salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public List<Endereco> listaEnderecosDePessoa(Long pessoaId) {
        Pessoa pessoa = validaIdPessoa(pessoaId);
        if (pessoa.getId() != null) {
            enderecos = pessoa.getEnderecos();
            return enderecos;
        }
        return enderecos.stream().toList();
    }
}
