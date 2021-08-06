package br.com.treinaweb.twbiblioteca.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.treinaweb.twbiblioteca.enums.Reputacao;
import br.com.treinaweb.twbiblioteca.enums.Tipo;
import br.com.treinaweb.twbiblioteca.models.Autor;
import br.com.treinaweb.twbiblioteca.models.Cliente;
import br.com.treinaweb.twbiblioteca.models.Obra;

public class EmprestimoServiceTest {

    @Test
    void quandoMetodoNovoForChamadoDeveRetornarUmEmprestimo() {
        // cenario
        var emprestimoService = new EmprestimoService();
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.REGULAR);
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(emprestimo.getCliente(), cliente);
        assertEquals(emprestimo.getLivros(), List.of(obra));
        assertEquals(emprestimo.getDataEmprestimo(), LocalDate.now());
        assertEquals(emprestimo.getDataDevolucao(), LocalDate.now().plusDays(3));
    }

}
