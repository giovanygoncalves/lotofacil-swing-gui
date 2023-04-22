package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.servico.Utilitario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidadorDeLimiteDeNumerosPorLinha implements Validador {

    private final List<Integer> limitesDeNumerosPorLinha;
    private final boolean[] limiteDeNumerosAtingido;

    public ValidadorDeLimiteDeNumerosPorLinha() {
        limitesDeNumerosPorLinha = new ArrayList<>(Arrays.asList(4, 2, 3, 3, 3));
        limiteDeNumerosAtingido = new boolean[5];
    }

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        atualizarLimiteDeNumerosAtingido(jogo.getNumerosMarcados());
        int indiceDaLinha = Utilitario.obterIndiceDaLinha(numeroSorteado);
        if (limiteDeNumerosAtingido[indiceDaLinha]) {
            return false;
        }
        List<Integer> limitesExcedidos = new ArrayList<>(limitesDeNumerosPorLinha);
        Collections.sort(limitesExcedidos);
        for (int i = 0; i < 5; i++) {
            if (limiteDeNumerosAtingido[i]) {
                continue;
            }
            int quantidadeDeNumerosMarcadosPorLinha = Utilitario.obterQuantidadeDeNumerosMarcadosPorLinha(jogo.getNumerosMarcados(), i);
            quantidadeDeNumerosMarcadosPorLinha += i == indiceDaLinha ? 1 : 0;
            for (Integer limite : limitesExcedidos) {
                if (quantidadeDeNumerosMarcadosPorLinha <= limite) {
                    limitesExcedidos.remove(limite);
                    break;
                }
            }
        }
        return limitesExcedidos.isEmpty();
    }

    private void atualizarLimiteDeNumerosAtingido(int[][] numerosMarcados) {
        Integer limiteMaximo = obterLimiteMaximo();
        for (int i = 0; i < 5; i++) {
            if (limiteDeNumerosAtingido[i]) {
                continue;
            }
            int quantidadeDeNumerosMarcadosPorLinha = Utilitario.obterQuantidadeDeNumerosMarcadosPorLinha(numerosMarcados, i);
            if (quantidadeDeNumerosMarcadosPorLinha == limiteMaximo) {
                limiteDeNumerosAtingido[i] = true;
                limitesDeNumerosPorLinha.remove(limiteMaximo);
                limiteMaximo = obterLimiteMaximo();
            }
        }
    }

    private Integer obterLimiteMaximo() {
        return Collections.max(limitesDeNumerosPorLinha);
    }

}
