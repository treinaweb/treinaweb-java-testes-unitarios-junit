package br.com.treinaweb.twbiblioteca.services;

import br.com.treinaweb.twbiblioteca.models.Emprestimo;

public interface NotificaoService {

    void notificar(Emprestimo emprestimo);

}
