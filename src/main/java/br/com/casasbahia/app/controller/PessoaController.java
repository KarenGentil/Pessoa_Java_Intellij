package br.com.casasbahia.app.controller;

import br.com.casasbahia.app.model.Pessoa;
import br.com.casasbahia.app.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
