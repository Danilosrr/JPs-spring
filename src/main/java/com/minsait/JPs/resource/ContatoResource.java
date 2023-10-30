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
@RequestMapping("/api/contatos")
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

    @PutMapping("/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody Contato contato){
        Contato upContato = contatoService.update(id,contato);
        return ResponseEntity.ok(upContato);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Contato> deleteContato(@PathVariable Long id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato.isPresent()) {
            contatoService.delete(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    };
}
