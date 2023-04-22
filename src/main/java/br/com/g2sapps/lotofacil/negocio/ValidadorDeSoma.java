package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.dominio.StatusDoNumero;

public class ValidadorDeSoma implements Validador {

    private int minimo;
    private int maximo;

    public ValidadorDeSoma() {
        minimo = 171;
        maximo = 220;
    }

    public ValidadorDeSoma(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        int soma = jogo.somarNumerosMarcados() + numeroSorteado;
        return (soma >= minimo || minimoAindaPodeSerAtingido(numeroSorteado, jogo)) && soma <= maximo;
    }

    private boolean minimoAindaPodeSerAtingido(int numeroSorteado, Jogo jogo) {
        int contagem = 0;
        int quantidadeDeNumerosQueFaltamSerMarcados = jogo.obterQuantidadeDeNumerosQueFaltamSerMarcados() - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA;
        int[][] numerosMarcados = jogo.getNumerosMarcados();
        int soma = jogo.somarNumerosMarcados() + numeroSorteado;
        for (int i = 4; i >= 0; i--) {
            for (int j = 4; j >= 0 && contagem < quantidadeDeNumerosQueFaltamSerMarcados; j--) {
                int numeroCorrespondente = 5 * i + j + 1;
                if (numerosMarcados[i][j] == StatusDoNumero.NUMERO_NAO_SORTEADO.getValor()) {
                    soma += numeroCorrespondente;
                    contagem++;
                }
            }
        }
        return soma >= minimo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

}
