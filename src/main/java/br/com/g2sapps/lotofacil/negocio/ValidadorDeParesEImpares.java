package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;
import static br.com.g2sapps.lotofacil.negocio.Validador.QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA;

public class ValidadorDeParesEImpares implements Validador {

    private static final int PARES = 0;
    private static final int IMPARES = 1;
    private final int[][] limites;

    public ValidadorDeParesEImpares() {
        limites = new int[][]{{7, 8}, {8, 7}, {6, 9}};
    }

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        return algumLimiteNaoFoiUltrapassado(numeroSorteado, jogo) && algumLimiteAindaPodeSerAtingido(numeroSorteado, jogo);
    }

    private boolean algumLimiteNaoFoiUltrapassado(int numeroSorteado, Jogo jogo) {
        boolean algumLimiteNaoFoiUltrapassado = false;
        int quantidadeDeNumerosPares = obterQuantidadeDeNumerosPares(numeroSorteado, jogo);
        int quantidadeDeNumerosImpares = obterQuantidadeDeNumerosImpares(numeroSorteado, jogo);
        for (int i = 0; i < 3; i++) {
            if (quantidadeDeNumerosPares <= limites[i][PARES] && quantidadeDeNumerosImpares <= limites[i][IMPARES]) {
                algumLimiteNaoFoiUltrapassado = true;
                break;
            }
        }
        return algumLimiteNaoFoiUltrapassado;
    }

    private boolean algumLimiteAindaPodeSerAtingido(int numeroSorteado, Jogo jogo) {
        boolean algumLimiteAindaPodeSerAtingido = false;
        int quantidadeDeNumerosPares = obterQuantidadeDeNumerosPares(numeroSorteado, jogo);
        int quantidadeDeNumerosImpares = obterQuantidadeDeNumerosImpares(numeroSorteado, jogo);
        for (int i = 0; i < 3; i++) {
            if (quantidadeDeNumerosPares > limites[i][PARES] || quantidadeDeNumerosImpares > limites[i][IMPARES]) {
                continue;
            }
            int quantidadeDeNumerosParesFaltantes = limites[i][PARES] - quantidadeDeNumerosPares;
            int quantidadeDeNumerosImparesFaltantes = limites[i][IMPARES] - quantidadeDeNumerosImpares;
            int quantidadeDeNumerosParesEImparesFaltantes = quantidadeDeNumerosParesFaltantes + quantidadeDeNumerosImparesFaltantes;
            int quantidadeDeNumerosQueFaltamSerMarcados = jogo.obterQuantidadeDeNumerosQueFaltamSerMarcados() - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA;
            if (quantidadeDeNumerosParesEImparesFaltantes <= quantidadeDeNumerosQueFaltamSerMarcados && quantidadeDeNumerosParesFaltantes <= jogo.obterQuantidadeDeNumerosParesNaoSorteados() && quantidadeDeNumerosImparesFaltantes <= jogo.obterQuantidadeDeNumerosImparesNaoSorteados()) {
                algumLimiteAindaPodeSerAtingido = true;
                break;
            }
        }
        return algumLimiteAindaPodeSerAtingido;
    }

    private int obterQuantidadeDeNumerosPares(int numeroSorteado, Jogo jogo) {
        int quantidadeDeNumerosPares = jogo.obterQuantidadeDeNumerosMarcadosPares();
        if (numeroSorteado % 2 == 0) {
            quantidadeDeNumerosPares++;
        }
        return quantidadeDeNumerosPares;
    }

    private int obterQuantidadeDeNumerosImpares(int numeroSorteado, Jogo jogo) {
        int quantidadeDeNumerosImpares = jogo.obterQuantidadeDeNumerosMarcadosImpares();
        if (numeroSorteado % 2 == 1) {
            quantidadeDeNumerosImpares++;
        }
        return quantidadeDeNumerosImpares;
    }

}
