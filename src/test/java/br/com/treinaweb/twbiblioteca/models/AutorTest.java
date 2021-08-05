package br.com.treinaweb.twbiblioteca.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AutorTest {

    @Test
    void quandoMetodoEstaVidoForChamadoComDataFalecimentoNulaDeveRetornarTrue() {
        // cenário
        var autor = new Autor();

        // execução
        var estaVido = autor.estaVivo();

        // verificação
        assertEquals(true, estaVido);
    }

    @Test
    void quandoMetodoEstaVivoForChamadoComDataFalecimentoPreenchidaDeveRetornarFalse() {
        // cenário
        var autor = new Autor();
        autor.setDataFalecimento(LocalDate.now());

        // execução
        var estaVivo = autor.estaVivo();

        // verificação
        assertEquals(false, estaVivo);
    }

}
