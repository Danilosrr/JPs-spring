package com.minsait.JPs.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column()
    private String endereco;
    @Column()
    private String cep;
    @Column()
    private String cidade;
    @Column()
    private String uf;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    List<Contato> contatos = new ArrayList<Contato>();

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }
    public String getCidade() {
        return cidade;
    }
    public String getUf() {
        return uf;
    }
    public List<Contato> getContatos() {
        return contatos;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf +"]";
    }
}
