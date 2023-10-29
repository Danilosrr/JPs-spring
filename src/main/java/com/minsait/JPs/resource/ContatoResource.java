package com.minsait.JPs.resource;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contato")
public class ContatoResource {
    private ContatoService contatoService;

    @Autowired
    public ContatoResource(ContatoService contatoService) {
        this.contatoService = contatoService;
    }
    @GetMapping
    public ResponseEntity<List<Contato>> getAll(){
        List<Contato> contatos = contatoService.getAll();
        return ResponseEntity.ok(contatos);
    };

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato){
        Contato newContato = contatoService.save(contato);
        if(newContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newContato);
    }
}
