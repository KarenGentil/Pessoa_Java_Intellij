package br.com.casasbahia.app.controller;

import br.com.casasbahia.app.model.Pessoa;
import br.com.casasbahia.app.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping(value = "{id}")
    public Pessoa findById(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }
    @PutMapping
    public Pessoa update(@RequestBody Pessoa pessoa) {
        return pessoaService.update(pessoa);
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        pessoaService.delete(id);
    }

}
