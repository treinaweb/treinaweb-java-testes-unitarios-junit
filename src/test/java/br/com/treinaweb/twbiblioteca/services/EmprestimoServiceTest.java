package br.com.treinaweb.twbiblioteca.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.treinaweb.twbiblioteca.builders.ClienteBuilder;
import br.com.treinaweb.twbiblioteca.builders.EmprestimoBuilder;
import br.com.treinaweb.twbiblioteca.builders.ObraBuilder;
import br.com.treinaweb.twbiblioteca.dao.EmprestimoDAO;
import br.com.treinaweb.twbiblioteca.enums.Reputacao;
import br.com.treinaweb.twbiblioteca.models.Obra;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceTest {

    @Mock
    private EmprestimoDAO emprestimoDAO;

    @Mock
    private NotificaoService notificaoService;

    @InjectMocks
    private EmprestimoService emprestimoService;

    @Test
    void quandoMetodoNovoForChamadoDeveRetornarUmEmprestimo() {
        // cenario
        var cliente = ClienteBuilder.builder().build();
        var obra = ObraBuilder.builder().build();

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
        var cliente = ClienteBuilder.builder().reputacao(Reputacao.RUIM).build();
        var obra = ObraBuilder.builder().build();

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(1), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteDeReputacaoRegularDeveRetornarUmEmprestimoComDevolucaoParaTresDias() {
        // cenario
        var cliente = ClienteBuilder.builder().build();
        var obra = ObraBuilder.builder().build();

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(3), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteDeReputacaoBoaDeveRetornarUmEmprestimoComDevolucaoParaCincoDias() {
        // cenario
        var cliente = ClienteBuilder.builder().reputacao(Reputacao.BOA).build();
        var obra = ObraBuilder.builder().build();

        // execução
        var emprestimo = emprestimoService.novo(cliente, List.of(obra));

        // verificação
        assertEquals(LocalDate.now().plusDays(5), emprestimo.getDataDevolucao());
    }

    @Test
    void quandoMetodoNovoForChamadoComObraNuloDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var cliente = ClienteBuilder.builder().build();
        var mensagemEsperada = "Obras não pode ser nulo e nem vazio";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(cliente, null));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void quandoMetodoNovoForChamadoComObraVaizaDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var cliente = ClienteBuilder.builder().build();
        var obras = new ArrayList<Obra>();
        var mensagemEsperada = "Obras não pode ser nulo e nem vazio";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(cliente, obras));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void quandoMetodoNovoForChamadoComClienteNuloDeveLancarUmaExcecaoDoTipoIllegalArgumentException() {
        // cenario
        var obra = ObraBuilder.builder().build();
        var mensagemEsperada = "Cliente não pode ser nulo";

        var exception = assertThrows(IllegalArgumentException.class, () -> emprestimoService.novo(null, List.of(obra)));
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void quandoMetodoNotificarAtrasoForChamadoDeveRetornarONumeroDeNotificacoes() {
        // cenario
        var emprestimos = List.of(
            EmprestimoBuilder.builder().build(),
            EmprestimoBuilder.builder().dataDevolucao(LocalDate.now().minusDays(1)).build()
        );

        when(emprestimoDAO.buscarTodos()).thenReturn(emprestimos);

        // execução
        emprestimoService.notificarAtrasos();

        // verificação
        verify(notificaoService).notificar(emprestimos.get(1));
    }

}
