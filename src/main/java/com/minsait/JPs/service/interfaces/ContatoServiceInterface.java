package com.minsait.JPs.service.interfaces;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    //Contato save(Contato contato);
    Contato saveContatoToPessoa(Pessoa pessoa, Contato contato);
    Optional<Contato> getById(Long id);
    List<Contato> getAll();
    Contato update(Long id, Contato contato);
    void delete(Long id);
}
