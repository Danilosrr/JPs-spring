package com.minsait.JPs.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long pessoa_id;
    @Column(nullable = false)
    private String contato;
    @Column(nullable = false)
    private EnumContatoTipo contatoTipo;

    public Long getId() {
        return id;
    }

    public Long getPessoa_id() { return pessoa_id; }
    public String getContato() {
        return contato;
    }
    public EnumContatoTipo getContatoTipo() {
        return contatoTipo;
    }

    public void setPessoa_id(Long pessoa_id) { this.pessoa_id = pessoa_id; }
    public void setContato(String contato) { this.contato = contato; }
    public void setContatoTipo(EnumContatoTipo contatoTipo) {
        this.contatoTipo = contatoTipo;
    }
}

enum EnumContatoTipo {
    TELEFONE(0), CELULAR(1);

    private final int valor;
    private EnumContatoTipo(int valor){
        this.valor = valor;
    }
};