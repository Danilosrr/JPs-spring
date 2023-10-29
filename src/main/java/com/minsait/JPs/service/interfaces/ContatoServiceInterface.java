package com.minsait.JPs.service.interfaces;

import com.minsait.JPs.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    Contato save(Contato contato);
    Optional<Contato> getById(Long id);
    List<Contato> getAll();
    Contato update(Contato contato);
    void delete(Long id);
}
