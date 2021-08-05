package br.com.treinaweb.twbiblioteca.models;

import java.time.LocalDate;
import java.util.List;

public class Emprestimo {

    private Long id;

    private Cliente cliente;

    private List<Obra> obras;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    public Emprestimo() {}

    public Emprestimo(Cliente cliente, List<Obra> obras, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.cliente = cliente;
        this.obras = obras;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Long id, Cliente cliente, List<Obra> obras, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.cliente = cliente;
        this.obras = obras;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Obra> getLivros() {
        return obras;
    }

    public void setLivros(List<Obra> obras) {
        this.obras = obras;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
        result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((obras == null) ? 0 : obras.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Emprestimo other = (Emprestimo) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (dataDevolucao == null) {
            if (other.dataDevolucao != null)
                return false;
        } else if (!dataDevolucao.equals(other.dataDevolucao))
            return false;
        if (dataEmprestimo == null) {
            if (other.dataEmprestimo != null)
                return false;
        } else if (!dataEmprestimo.equals(other.dataEmprestimo))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (obras == null) {
            if (other.obras != null)
                return false;
        } else if (!obras.equals(other.obras))
            return false;
        return true;
    }

}
