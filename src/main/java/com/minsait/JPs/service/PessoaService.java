package com.minsait.JPs.service;

import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.repository.ContatoRepository;
import com.minsait.JPs.repository.PessoaRepository;
import com.minsait.JPs.service.interfaces.PessoaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {
    private PessoaRepository pessoaRepository;
    private ContatoRepository contatoRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, ContatoRepository contatoRepository){
        this.pessoaRepository = pessoaRepository; this.contatoRepository = contatoRepository;
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
    public Pessoa update(Pessoa pessoa) {
        Optional<Pessoa> upPessoa= pessoaRepository.findById(pessoa.getId());

        if(upPessoa.isPresent()) {
            Pessoa newProduto = upPessoa.get();
            newProduto.setNome(pessoa.getNome());
            newProduto.setEndereco(pessoa.getEndereco());
            newProduto.setCep(pessoa.getCep());
            newProduto.setCidade(pessoa.getCidade());
            newProduto.setUf(pessoa.getUf());
            return pessoaRepository.save(newProduto);
        }
        return pessoa;
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
