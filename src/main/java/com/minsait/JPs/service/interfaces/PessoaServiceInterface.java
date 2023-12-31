package com.minsait.JPs.service.interfaces;

import com.minsait.JPs.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {
    Pessoa save(Pessoa pessoa);
    Optional<Pessoa> getById(Long id);
    List<Pessoa> getAll();
    Pessoa update(Long id, Pessoa pessoa);
    void delete(Long id);
}
