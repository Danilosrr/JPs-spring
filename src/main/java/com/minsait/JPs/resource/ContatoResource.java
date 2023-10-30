package com.minsait.JPs.resource;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.service.ContatoService;
import com.minsait.JPs.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
    private ContatoService contatoService;

    @Autowired
    public ContatoResource(ContatoService contatoService) {
        this.contatoService = contatoService;
    };

    @Operation(summary = "Lista contatos", description = "Lista todos os contatos da aplicação.")
    @GetMapping
    public ResponseEntity<List<Contato>> getAll(){
        List<Contato> contatos = contatoService.getAll();
        return ResponseEntity.ok(contatos);
    };

    @Operation(summary = "Modificar contato", description = "Modifica um contato vinculado ao id de uma pessoa passado como parâmetro de rota.")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody Contato contato){
        Contato upContato = contatoService.update(id,contato);
        return ResponseEntity.ok(upContato);
    };

    @Operation(summary = "Deletar contato", description = "Faz a deleção de contatos utilizando o id passado como parâmetro de rota")
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