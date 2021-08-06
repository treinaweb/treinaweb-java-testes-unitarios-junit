package br.com.treinaweb.twbiblioteca.services;

import java.time.LocalDate;
import java.util.List;

import br.com.treinaweb.twbiblioteca.enums.Reputacao;
import br.com.treinaweb.twbiblioteca.models.Cliente;
import br.com.treinaweb.twbiblioteca.models.Emprestimo;
import br.com.treinaweb.twbiblioteca.models.Obra;

public class EmprestimoService {

    public Emprestimo novo(Cliente cliente, List<Obra> obras) {
        var emprestimo = new Emprestimo();

        var dataEmprestimo = LocalDate.now();
        var diasParaDevolucao = 3;
        if (cliente.getReputacao() == Reputacao.RUIM) {
            diasParaDevolucao = 1;
        } else if (cliente.getReputacao() == Reputacao.REGULAR) {
            diasParaDevolucao = 3;
        } else {
            diasParaDevolucao = 5;
        }
        var dataDevolucao = dataEmprestimo.plusDays(diasParaDevolucao);

        emprestimo.setCliente(cliente);
        emprestimo.setLivros(obras);
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataDevolucao(dataDevolucao);

        return emprestimo;
    }

}
