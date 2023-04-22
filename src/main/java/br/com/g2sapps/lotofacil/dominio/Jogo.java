package br.com.g2sapps.lotofacil.dominio;

import br.com.g2sapps.lotofacil.servico.Utilitario;
import java.util.ArrayList;
import java.util.List;

public class Jogo {

    private final int[][] numerosMarcados;
    private final List<Integer> listaDeNumerosMarcados;

    public Jogo() {
        numerosMarcados = new int[5][5];
        listaDeNumerosMarcados = new ArrayList<>();
    }

    public void sinalizarNumeroNaoValidadoAinda(int numero) {
        int i = Utilitario.obterIndiceDaLinha(numero);
        int j = Utilitario.obterIndiceDaColuna(numero);
        numerosMarcados[i][j] = StatusDoNumero.NUMERO_NAO_VALIDADO_AINDA.getValor();
    }

    public void marcarNumero(int numero) {
        int i = Utilitario.obterIndiceDaLinha(numero);
        int j = Utilitario.obterIndiceDaColuna(numero);
        numerosMarcados[i][j] = numero;
        listaDeNumerosMarcados.add(numero);
    }

    public void sinalizarNumeroInvalido(int numero) {
        int i = Utilitario.obterIndiceDaLinha(numero);
        int j = Utilitario.obterIndiceDaColuna(numero);
        numerosMarcados[i][j] = StatusDoNumero.NUMERO_INVALIDO.getValor();
    }

    public int obterQuantidadeDeNumerosMarcados() {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numerosMarcados[i][j] > 0) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int somarNumerosMarcados() {
        int soma = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numerosMarcados[i][j] > 0) {
                    soma += numerosMarcados[i][j];
                }
            }
        }
        return soma;
    }

    public int obterQuantidadeDeNumerosMarcadosPares() {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numerosMarcados[i][j] > 0 && numerosMarcados[i][j] % 2 == 0) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int obterQuantidadeDeNumerosMarcadosImpares() {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numerosMarcados[i][j] > 0 && numerosMarcados[i][j] % 2 == 1) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int obterQuantidadeDeNumerosParesNaoSorteados() {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroCorrespondente = 5 * i + j + 1;
                if (numerosMarcados[i][j] == StatusDoNumero.NUMERO_NAO_SORTEADO.getValor() && numeroCorrespondente % 2 == 0) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int obterQuantidadeDeNumerosImparesNaoSorteados() {
        int quantidade = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroCorrespondente = 5 * i + j + 1;
                if (numerosMarcados[i][j] == StatusDoNumero.NUMERO_NAO_SORTEADO.getValor() && numeroCorrespondente % 2 == 1) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int obterQuantidadeDeNumerosRepetidosDoUltimoConcurso(List<Integer> numerosSorteadosNoUltimoConcurso) {
        return Utilitario.obterQuantidadeDeNumerosRepetidosDoUltimoConcurso(numerosMarcados, numerosSorteadosNoUltimoConcurso);
    }

    public int obterQuantidadeDeNumerosQueFaltamSerMarcados() {
        return Apostador.MARCAR_QUANTOS_NUMEROS - obterQuantidadeDeNumerosMarcados();
    }

    public int obterQuantidadeDeNumerosMarcadosPrimos() {
        int quantidade = 0;
        for (Integer numeroMarcado : listaDeNumerosMarcados) {
            if (Utilitario.numeroPrimo(numeroMarcado)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int[][] getNumerosMarcados() {
        return numerosMarcados;
    }

    public List<Integer> getListaDeNumerosMarcados() {
        return listaDeNumerosMarcados;
    }

}
