package com.minsait.JPs.resource;

import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.service.ContatoService;
import com.minsait.JPs.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {
    private PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService) { this.pessoaService = pessoaService; }
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = pessoaService.getAll();
        return ResponseEntity.ok(pessoas);
    };

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.save(pessoa);
        if(newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }
}
