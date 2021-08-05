package br.com.treinaweb.twbiblioteca.models;

import java.time.LocalDate;

import br.com.treinaweb.twbiblioteca.enums.Reputacao;

public class Cliente extends Pessoa {

    private String cpf;

    private Reputacao reputacao;

    public Cliente() {}

    public Cliente(String nome, LocalDate dataNascimento, String cpf, Reputacao reputacao) {
        super(nome, dataNascimento);
        this.cpf = cpf;
        this.reputacao = reputacao;
    }

    public Cliente(Long id, String nome, LocalDate dataNascimento, String cpf, Reputacao reputacao) {
        super(id, nome, dataNascimento);
        this.cpf = cpf;
        this.reputacao = reputacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Reputacao getReputacao() {
        return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
        this.reputacao = reputacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((reputacao == null) ? 0 : reputacao.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (reputacao != other.reputacao)
            return false;
        return true;
    }

}
