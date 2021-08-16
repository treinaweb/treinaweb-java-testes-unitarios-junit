package br.com.treinaweb.twbiblioteca.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.treinaweb.twbiblioteca.enums.Reputacao;
import br.com.treinaweb.twbiblioteca.enums.Tipo;
import br.com.treinaweb.twbiblioteca.models.Autor;
import br.com.treinaweb.twbiblioteca.models.Cliente;
import br.com.treinaweb.twbiblioteca.models.Obra;

public class EmprestimoServiceTest {

    private EmprestimoService emprestimoService;

    @BeforeEach
    private void setUp() {
        emprestimoService = new EmprestimoService();
    }

    @Test
    void quandoMetodoNovoForChamadoDeveRetornarUmEmprestimo() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.REGULAR);
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(cliente, emprestimo.getCliente());
        assertEquals(List.of(obra), emprestimo.getLivros());
        assertEquals(LocalDate.now(), emprestimo.getDataEmprestimo());
        assertEquals(LocalDate.now().plusDays(3), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteDeReputacaoRuimDeveRetornarUmEmprestimoComDevolucaoParaUmDias() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.RUIM);
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(1), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteDeReputacaoRegularDeveRetornarUmEmprestimoComDevolucaoParaTresDias() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.REGULAR);
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(3), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteDeReputacaoBoaDeveRetornarUmEmprestimoComDevolucaoParaCincoDias() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.BOA);
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(5), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComObraNuloDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.REGULAR);
        var mensagemEsperada = "Obras não pode ser nulo e nem vazio";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(cliente, null));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void quandoMetodoNovoForChamadoComObraVaizaDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var cliente = new Cliente(1L, "Cleinte Teste", LocalDate.now(), "123.123.123-11", Reputacao.REGULAR);
        var obras = new ArrayList<Obra>();
        var mensagemEsperada = "Obras não pode ser nulo e nem vazio";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(cliente, obras));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteNuloDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var autor = new Autor(1L, "Autor Teste", LocalDate.now(), null);
        var obra = new Obra(1L, "Obra Teste", 100, Tipo.LIVRO, autor);
        var mensagemEsperada = "Cliente não pode ser nulo";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(null, List.of(obra)));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

}
