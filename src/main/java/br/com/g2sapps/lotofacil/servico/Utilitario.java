package br.com.g2sapps.lotofacil.servico;

import br.com.g2sapps.lotofacil.dominio.NumerosPrimos;
import java.util.List;

public abstract class Utilitario {

    public static int obterIndiceDaLinha(int numero) {
        return (numero - 1) / 5;
    }

    public static int obterIndiceDaColuna(int numero) {
        return (numero - 1) % 5;
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

    public static int obterQuantidadeDeNumerosMarcadosPorColuna(int[][] numerosMarcados, int indiceDaColuna) {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            if (numerosMarcados[i][indiceDaColuna] > 0) {
                quantidade++;
            }
        }
        return quantidade;
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

    public static boolean numeroPrimo(int numero) {
        return NumerosPrimos.obterNumerosPrimosDe1A25().contains(numero);
    }

}
