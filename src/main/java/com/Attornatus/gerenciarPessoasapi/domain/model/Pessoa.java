package com.Attornatus.gerenciarPessoasapi.domain.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataDeNascimento;
    @ManyToOne
    @Nullable
    private Endereco endereco;

}