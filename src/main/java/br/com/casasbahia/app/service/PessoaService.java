package br.com.casasbahia.app.service;

import br.com.casasbahia.app.model.Pessoa;
import br.com.casasbahia.app.repository.PessoaRepository;
import br.com.casasbahia.app.util.CalculoIdade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PessoaService {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    CalculoIdade calculoIdade;

    public List<Pessoa> findAll() {
        log.info("Pesquisando todas as pessoas");
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        log.info("Pesquisando pessoa com ID: " + id);
        return pessoaRepository.findById(id).orElseThrow();
    }

    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdade(calculoIdade.calcularIdade(pessoa.getDataNascimento()));
        log.info("Criando Pessoa: " + pessoa.getNome());
        return pessoaRepository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaAtual = findById(pessoa.getId());
        pessoaAtual.setNome(pessoa.getNome());
        pessoaAtual.setDataNascimento(pessoa.getDataNascimento());
        pessoaAtual.setAltura(pessoa.getAltura());
        pessoaAtual.setCidade(pessoa.getCidade());
        pessoaAtual.setGenero(pessoa.getGenero());
        pessoaAtual.setTelefone(pessoa.getTelefone());
        log.info("Atualizando Pessoa: " + pessoaAtual.getNome());
        return pessoaRepository.save(pessoaAtual);
    }

    public void delete(Long id) {
        log.info("Deletando Pessoa: " + id);
        pessoaRepository.deleteById(id);
    }


}
