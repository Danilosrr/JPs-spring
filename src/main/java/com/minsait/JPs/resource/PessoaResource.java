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
@RequestMapping("/api/pessoas")
public class PessoaResource {
    private PessoaService pessoaService;
    private ContatoService contatoService;

    @Autowired
    public PessoaResource(PessoaService pessoaService, ContatoService contatoService) {
        this.pessoaService = pessoaService;
        this.contatoService = contatoService;
    };

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = pessoaService.getAll();
        return ResponseEntity.ok(pessoas);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa upPessoa = pessoaService.update(id, pessoa);
        return ResponseEntity.ok(upPessoa);
    };

    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.save(pessoa);
        if(newPessoa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(newPessoa);
        }
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletePessoa(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa.isPresent()) {
            pessoaService.delete(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    };

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    };

    @GetMapping("/{idPessoa}/contatos")
    public ResponseEntity<List<Contato>> getContatosById(@PathVariable Long idPessoa){
        Optional<Pessoa> pessoa = pessoaService.getById(idPessoa);
        if(pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get().getContatos());
        }else{
            return ResponseEntity.notFound().build();
        }
    };

    @PostMapping("/{id}/contatos")
    public ResponseEntity<Contato> savePessoaContato(@RequestBody Contato contato, @PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);

        if (pessoa.isPresent()) {
            contatoService.saveContatoToPessoa(pessoa.get(), contato);
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    };
}
