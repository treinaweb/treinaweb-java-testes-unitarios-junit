package br.com.treinaweb.twbiblioteca.models;

import br.com.treinaweb.twbiblioteca.enums.Tipo;

public class Obra {

    private Long id;

    private String nome;

    private Integer qtdPaginas;

    private Tipo tipo;

    private Autor autor;

    public Obra() {}

    public Obra(String nome, Integer qtdPaginas, Tipo tipo, Autor autor) {
        this.nome = nome;
        this.qtdPaginas = qtdPaginas;
        this.tipo = tipo;
        this.autor = autor;
    }

    public Obra(Long id, String nome, Integer qtdPaginas, Tipo tipo, Autor autor) {
        this.id = id;
        this.nome = nome;
        this.qtdPaginas = qtdPaginas;
        this.tipo = tipo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((qtdPaginas == null) ? 0 : qtdPaginas.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Obra other = (Obra) obj;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (qtdPaginas == null) {
            if (other.qtdPaginas != null)
                return false;
        } else if (!qtdPaginas.equals(other.qtdPaginas))
            return false;
        if (tipo != other.tipo)
            return false;
        return true;
    }

}
