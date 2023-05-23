package br.com.g2sapps.lotofacil.utilidade;

import java.util.List;

public final class UtilitarioDeNumerosRepetidos {

    private UtilitarioDeNumerosRepetidos() {
    }

    public static int obterQuantidadeDeNumerosRepetidosDoUltimoConcurso(int[][] numerosMarcados, List<Integer> numerosSorteadosNoUltimoConcurso) {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numerosSorteadosNoUltimoConcurso.contains(numerosMarcados[i][j])) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

}
