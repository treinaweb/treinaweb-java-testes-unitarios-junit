package br.com.treinaweb.twbiblioteca.builders;

import java.time.LocalDate;
import java.util.List;

import br.com.treinaweb.twbiblioteca.models.Emprestimo;

public class EmprestimoBuilder {

    private Emprestimo emprestimo;

    public static EmprestimoBuilder builder() {
        var builder = new EmprestimoBuilder();

        var cliente = ClienteBuilder.builder().build();
        var obra = ObraBuilder.builder().build();
        var dataEmprestimo = LocalDate.now();
        var dataDevolucao = dataEmprestimo.plusDays(3);
        var emprestimo = new Emprestimo(1L, cliente, List.of(obra), dataEmprestimo, dataDevolucao);
        builder.emprestimo = emprestimo;

        return builder;
    }

    public EmprestimoBuilder dataDevolucao(LocalDate dataDevolucao) {
        emprestimo.setDataDevolucao(dataDevolucao);

        return this;
    }

    public Emprestimo build() {
        return emprestimo;
    }

}
