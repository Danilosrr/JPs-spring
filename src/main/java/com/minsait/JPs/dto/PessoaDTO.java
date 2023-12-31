package com.minsait.JPs.dto;

import com.minsait.JPs.model.Pessoa;

public class PessoaDTO {
    private  final Long id;
    private final String nome;
    private final String malaDireta;

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.malaDireta = String.format("%s - CEP: %s - %s/%s", pessoa.getEndereco(),pessoa.getCep(),pessoa.getCidade(),pessoa.getUf());
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getMalaDireta() { return malaDireta; }
}
