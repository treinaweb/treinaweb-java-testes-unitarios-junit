package br.com.treinaweb.twbiblioteca.models;

import java.time.LocalDate;

public class Autor extends Pessoa {

    private LocalDate dataFalecimento;

    public Autor() {}

    public Autor(String nome, LocalDate dataNascimento, LocalDate dataFalecimento) {
        super(nome, dataNascimento);
        this.dataFalecimento = dataFalecimento;
    }

    public Autor(Long id, String nome, LocalDate dataNascimento, LocalDate dataFalecimento) {
        super(id, nome, dataNascimento);
        this.dataFalecimento = dataFalecimento;
    }

    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dataFalecimento == null) ? 0 : dataFalecimento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autor other = (Autor) obj;
        if (dataFalecimento == null) {
            if (other.dataFalecimento != null)
                return false;
        } else if (!dataFalecimento.equals(other.dataFalecimento))
            return false;
        return true;
    }

    public boolean estaVivo() {
        return dataFalecimento == null;
    }

}
