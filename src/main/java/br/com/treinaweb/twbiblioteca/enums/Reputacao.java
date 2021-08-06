package br.com.treinaweb.twbiblioteca.enums;

public enum Reputacao {
    RUIM {
        @Override
        public int obterDiasParaDevolucao() {
            return 1;
        }
    }, REGULAR {
        @Override
        public int obterDiasParaDevolucao() {
            return 3;
        }
    }, BOA {
        @Override
        public int obterDiasParaDevolucao() {
            return 5;
        }
    };

    public abstract int obterDiasParaDevolucao();
}
