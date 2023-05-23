package br.com.g2sapps.lotofacil.utilidade;

public final class UtilitarioDeLinha {

    private UtilitarioDeLinha() {
    }

    public static int obterIndiceDaLinha(int numero) {
        return (numero - 1) / 5;
    }

    public static int obterQuantidadeDeNumerosMarcadosPorLinha(int[][] numerosMarcados, int indiceDaLinha) {
        int quantidade = 0;
        for (int j = 0; j < 5; j++) {
            if (numerosMarcados[indiceDaLinha][j] > 0) {
                quantidade++;
            }
        }
        return quantidade;
    }

}
