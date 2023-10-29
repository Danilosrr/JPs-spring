package com.minsait.JPs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false)
    private EnumContatoTipo contatoTipo;

    public Long getId() {
        return id;
    }

    public String getContato() {
        return contato;
    }

    public EnumContatoTipo getContatoTipo() {
        return contatoTipo;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

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