package br.com.casasbahia.app.util;

import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class CalculoIdade {

    public long calcularIdade(Date dataNascimento) {
        Date dataAtual = new Date();
        long idade = ChronoUnit.YEARS.between(
                dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                dataAtual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );
        return idade;
    }
}
