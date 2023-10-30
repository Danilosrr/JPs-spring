package com.minsait.JPs.service;

import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.repository.PessoaRepository;
import com.minsait.JPs.service.interfaces.PessoaServiceInterface;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {
    private PessoaRepository pessoaRepository;

    @Autowired
    private Validator validator;
    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa save(Pessoa pessoa) { return pessoaRepository.save(pessoa); }

    @Override
    public Optional<Pessoa> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        Optional<Pessoa> upPessoa= pessoaRepository.findById(id);

        if(upPessoa.isPresent()) {
            Pessoa newProduto = upPessoa.get();
            newProduto.setNome(pessoa.getNome());
            newProduto.setEndereco(pessoa.getEndereco());
            newProduto.setCep(pessoa.getCep());
            newProduto.setCidade(pessoa.getCidade());
            newProduto.setUf(pessoa.getUf());
            newProduto.setContatos(pessoa.getContatos());
            return pessoaRepository.save(newProduto);
        }
        return pessoa;
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
