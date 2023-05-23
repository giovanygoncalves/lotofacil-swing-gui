package br.com.g2sapps.lotofacil.utilidade;

public final class UtilitarioDeColuna {

    private UtilitarioDeColuna() {
    }

    public static int obterIndiceDaColuna(int numero) {
        return (numero - 1) % 5;
    }

    public static int obterQuantidadeDeNumerosMarcadosPorColuna(int[][] numerosMarcados, int indiceDaColuna) {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            if (numerosMarcados[i][indiceDaColuna] > 0) {
                quantidade++;
            }
        }
        return quantidade;
    }

}
