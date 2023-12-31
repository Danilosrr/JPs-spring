package com.minsait.JPs.service;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.repository.ContatoRepository;
import com.minsait.JPs.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService implements ContatoServiceInterface {
    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){ this.contatoRepository = contatoRepository; }

    @Override
    public Contato saveContatoToPessoa(Pessoa pessoa, Contato contato) {
        contato.setPessoa_id(pessoa.getId());
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> getById(Long id) { return contatoRepository.findById(id); }

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato update(Long id, Contato contato) {
        Optional<Contato> upContato = contatoRepository.findById(id);

        if(upContato.isPresent()) {
            Contato newContato = upContato.get();
            newContato.setContato(contato.getContato());
            newContato.setContatoTipo(contato.getContatoTipo());
            return contatoRepository.save(newContato);
        }
        return contato;
    }

    @Override
    public void delete(Long id) { contatoRepository.deleteById(id); }
}
