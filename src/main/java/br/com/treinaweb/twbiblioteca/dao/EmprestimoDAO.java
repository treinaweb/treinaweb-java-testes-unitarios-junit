package br.com.treinaweb.twbiblioteca.dao;

import java.util.List;

import br.com.treinaweb.twbiblioteca.models.Emprestimo;

public interface EmprestimoDAO {

    List<Emprestimo> buscarTodos();

}
