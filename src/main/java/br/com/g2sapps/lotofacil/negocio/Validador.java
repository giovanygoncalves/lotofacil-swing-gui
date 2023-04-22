package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;

public interface Validador {

    public static final int QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA = 1;

    public boolean validar(int numeroSorteado, Jogo jogo);

}
