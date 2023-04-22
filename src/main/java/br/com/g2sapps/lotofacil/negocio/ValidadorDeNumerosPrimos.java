package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Apostador;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.dominio.NumerosPrimos;
import java.util.List;

public class ValidadorDeNumerosPrimos implements Validador {

    private List<Integer> numerosPrimos;
    private int minimo;
    private int maximo;

    public ValidadorDeNumerosPrimos() {
        inicializarNumerosPrimos();
        minimo = 4;
        maximo = 6;
    }

    public ValidadorDeNumerosPrimos(int minimo, int maximo) {
        inicializarNumerosPrimos();
        this.minimo = minimo;
        this.maximo = maximo;
    }

    private void inicializarNumerosPrimos() {
        numerosPrimos = NumerosPrimos.obterNumerosPrimosDe1A25();
    }

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        int quantidadeDeNumerosPrimos = numerosPrimos.contains(numeroSorteado) ? 1 : 0;
        for (Integer numerosMarcado : jogo.getListaDeNumerosMarcados()) {
            if (numerosPrimos.contains(numerosMarcado)) {
                quantidadeDeNumerosPrimos++;
            }
        }
        return (quantidadeDeNumerosPrimos >= minimo || minimoAindaPodeSerAtingido(quantidadeDeNumerosPrimos, jogo.obterQuantidadeDeNumerosMarcados())) && quantidadeDeNumerosPrimos <= maximo;
    }

    private boolean minimoAindaPodeSerAtingido(int quantidadeDeNumerosPrimos, int quantidadeDeNumerosMarcados) {
        return Apostador.MARCAR_QUANTOS_NUMEROS - quantidadeDeNumerosMarcados - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA >= minimo - quantidadeDeNumerosPrimos;
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
