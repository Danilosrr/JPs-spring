package com.minsait.JPs.resource;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.service.ContatoService;
import com.minsait.JPs.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contato")
public class ContatoResource {
    private ContatoService contatoService;
    private PessoaService pessoaService;

    @Autowired
    public ContatoResource(ContatoService contatoService, PessoaService pessoaService) {
        this.contatoService = contatoService;
        this.pessoaService = pessoaService;
    }
    @GetMapping
    public ResponseEntity<List<Contato>> getAll(){
        List<Contato> contatos = contatoService.getAll();
        return ResponseEntity.ok(contatos);
    };

    @PostMapping("/{id}")
    public ResponseEntity<Contato> save(@RequestBody Contato contato, @PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);

        if (pessoa.isPresent()) {
            contato.setPessoa_id(pessoa.get().getId());
            contatoService.save(contato);
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    };
}
