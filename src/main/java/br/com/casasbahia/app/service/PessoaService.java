package br.com.casasbahia.app.service;

import br.com.casasbahia.app.model.Pessoa;
import br.com.casasbahia.app.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PessoaService {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        log.info("Pesquisando todas as pessoas");
        return pessoaRepository.findAll();
    }
}
