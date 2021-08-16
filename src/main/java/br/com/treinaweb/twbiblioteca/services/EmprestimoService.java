package br.com.treinaweb.twbiblioteca.services;

import java.time.LocalDate;
import java.util.List;

import br.com.treinaweb.twbiblioteca.dao.EmprestimoDAO;
import br.com.treinaweb.twbiblioteca.models.Cliente;
import br.com.treinaweb.twbiblioteca.models.Emprestimo;
import br.com.treinaweb.twbiblioteca.models.Obra;

public class EmprestimoService {

    private EmprestimoDAO emprestimoDAO;

    private NotificaoService notificaoService;

    public EmprestimoService(EmprestimoDAO emprestimoDAO, NotificaoService notificaoService) {
        this.emprestimoDAO = emprestimoDAO;
        this.notificaoService = notificaoService;
    }

    public Emprestimo novo(Cliente cliente, List<Obra> obras) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }

        if (obras == null || obras.isEmpty()) {
            throw new IllegalArgumentException("Obras não pode ser nulo e nem vazio");
        }

        var emprestimo = new Emprestimo();

        var dataEmprestimo = LocalDate.now();
        var diasParaDevolucao = cliente.getReputacao().obterDiasParaDevolucao();
        var dataDevolucao = dataEmprestimo.plusDays(diasParaDevolucao);

        emprestimo.setCliente(cliente);
        emprestimo.setLivros(obras);
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataDevolucao(dataDevolucao);

        return emprestimo;
    }

    public void notificarAtrasos() {
        var hoje = LocalDate.now();

        var emprestimos = emprestimoDAO.buscarTodos();

        for (Emprestimo emprestimo : emprestimos) {
            var estaAtrasado = emprestimo.getDataDevolucao().isBefore(hoje);
            if (estaAtrasado) {
                notificaoService.notificar(emprestimo);
            }
        }
    }

}
