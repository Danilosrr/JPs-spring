package com.minsait.JPs.model;

import jakarta.persistence.*;
import static jakarta.persistence.CascadeType.ALL;

import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column()
    private String endereco;

    @Column(nullable = false)
    private String cep;

    @Column()
    private String cidade;

    @Column()
    private String uf;

    @OneToMany(targetEntity = Contato.class, cascade = ALL)
    @JoinColumn(name = "pc_fk",referencedColumnName = "id")
    List<Contato> contatos;

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

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + "cidade=" + cidade + "uf=" + uf +"]";
    }
}
