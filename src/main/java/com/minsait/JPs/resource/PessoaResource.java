package com.minsait.JPs.resource;

import com.minsait.JPs.dto.PessoaDTO;
import com.minsait.JPs.model.Contato;
import com.minsait.JPs.model.Pessoa;
import com.minsait.JPs.service.ContatoService;
import com.minsait.JPs.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas cadastradas na aplicação.")
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = pessoaService.getAll();
        return ResponseEntity.ok(pessoas);
    };

    @Operation(summary = "Modificar pessoa", description = "Modifica uma pessoa vinculada ao id passado como parâmetro de rota.")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa upPessoa = pessoaService.update(id, pessoa);
        return ResponseEntity.ok(upPessoa);
    };

    @Operation(summary = "Registrar pessoa", description = "Registra uma nova pessoa na aplicação.")
    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@Valid @RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.save(pessoa);
        if(newPessoa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(newPessoa);
        }
    };

    @Operation(summary = "Deletar pessoa", description = "Deleta uma pessoa vinculada ao id passado como parâmetro de rota.")
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

    @Operation(summary = "Mostrar pessoa", description = "Mostra a pessoa vinculada ao id passado como parâmetro de rota.")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    };

    @Operation(summary = "Listar contatos de uma pessoa", description = "Lista todos os contatos vinculados ao id de uma pessoa passado como parâmetro de rota.")
    @GetMapping("/{idPessoa}/contatos")
    public ResponseEntity<List<Contato>> getContatosById(@PathVariable Long idPessoa){
        Optional<Pessoa> pessoa = pessoaService.getById(idPessoa);
        if(pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get().getContatos());
        }else{
            return ResponseEntity.notFound().build();
        }
    };

    @Operation(summary = "Mostrar mala direta", description = "Mostra mala direta vinculada ao id de uma pessoa passado como parâmetro de rota.")
    @GetMapping("/maladireta/{idPessoa}")
    public ResponseEntity<PessoaDTO> getMalaDiretaById(@PathVariable Long idPessoa){
        Optional<Pessoa> pessoa = pessoaService.getById(idPessoa);
        if(pessoa.isPresent()) {
            return ResponseEntity.ok(new PessoaDTO(pessoa.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    };

    @Operation(summary = "Registrar contato", description = "Registra um novo contato vinculado ao id da pessoa passado como parâmetro de rota.")
    @PostMapping("/{id}/contatos")
    public ResponseEntity<Contato> savePessoaContato(@Valid @RequestBody Contato contato, @PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);

        if (pessoa.isPresent()) {
            contatoService.saveContatoToPessoa(pessoa.get(), contato);
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    };
}
