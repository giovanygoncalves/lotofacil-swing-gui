package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Apostador;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.servico.Utilitario;
import java.util.List;

public class ValidadorDeNumerosRepetidos implements Validador {

    private final List<Integer> numerosSorteadosNoUltimoConcurso;
    private int minimo;
    private int maximo;

    public ValidadorDeNumerosRepetidos(List<Integer> numerosSorteadosNoUltimoConcurso) {
        this.numerosSorteadosNoUltimoConcurso = numerosSorteadosNoUltimoConcurso;
        minimo = 9;
        maximo = 9;
    }

    public ValidadorDeNumerosRepetidos(List<Integer> numerosSorteadosNoUltimoConcurso, int minimo, int maximo) {
        this.numerosSorteadosNoUltimoConcurso = numerosSorteadosNoUltimoConcurso;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        int quantidadeDeNumerosRepetidos = numerosSorteadosNoUltimoConcurso.contains(numeroSorteado) ? 1 : 0;
        quantidadeDeNumerosRepetidos += Utilitario.obterQuantidadeDeNumerosRepetidosDoUltimoConcurso(jogo.getNumerosMarcados(), numerosSorteadosNoUltimoConcurso);
        int quantidadeDeNumerosMarcados = jogo.obterQuantidadeDeNumerosMarcados();
        return (quantidadeDeNumerosRepetidos >= minimo || minimoAindaPodeSerAtingido(quantidadeDeNumerosRepetidos, quantidadeDeNumerosMarcados)) && quantidadeDeNumerosRepetidos <= maximo;
    }

    private boolean minimoAindaPodeSerAtingido(int quantidadeDeNumerosRepetidos, int quantidadeDeNumerosMarcados) {
        return Apostador.MARCAR_QUANTOS_NUMEROS - quantidadeDeNumerosMarcados - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA >= minimo - quantidadeDeNumerosRepetidos;
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
