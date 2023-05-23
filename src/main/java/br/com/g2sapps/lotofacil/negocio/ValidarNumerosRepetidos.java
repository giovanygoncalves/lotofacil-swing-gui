package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Bola;
import br.com.g2sapps.lotofacil.dominio.EntidadeDeDominio;
import br.com.g2sapps.lotofacil.dominio.Gerador;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.utilidade.UtilitarioDeNumerosRepetidos;
import java.util.List;

public class ValidarNumerosRepetidos extends ValidarBolaSorteada {

    private final List<Integer> numerosSorteadosNoUltimoConcurso;
    private int minimo;
    private int maximo;

    public ValidarNumerosRepetidos(List<Integer> numerosSorteadosNoUltimoConcurso) {
        this.numerosSorteadosNoUltimoConcurso = numerosSorteadosNoUltimoConcurso;
        minimo = 9;
        maximo = 9;
    }

    public ValidarNumerosRepetidos(List<Integer> numerosSorteadosNoUltimoConcurso, int minimo, int maximo) {
        this.numerosSorteadosNoUltimoConcurso = numerosSorteadosNoUltimoConcurso;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean processar(EntidadeDeDominio entidadeDeDominio) {
        Bola bolaSorteada = (Bola) entidadeDeDominio;
        int numeroSorteado = bolaSorteada.getNumero();
        Jogo jogo = bolaSorteada.getJogo();
        int quantidadeDeNumerosRepetidos = numerosSorteadosNoUltimoConcurso.contains(numeroSorteado) ? 1 : 0;
        quantidadeDeNumerosRepetidos += UtilitarioDeNumerosRepetidos.obterQuantidadeDeNumerosRepetidosDoUltimoConcurso(jogo.getNumerosMarcados(), numerosSorteadosNoUltimoConcurso);
        int quantidadeDeNumerosMarcados = jogo.obterQuantidadeDeNumerosMarcados();
        return (quantidadeDeNumerosRepetidos >= minimo || minimoAindaPodeSerAtingido(quantidadeDeNumerosRepetidos, quantidadeDeNumerosMarcados)) && quantidadeDeNumerosRepetidos <= maximo;
    }

    private boolean minimoAindaPodeSerAtingido(int quantidadeDeNumerosRepetidos, int quantidadeDeNumerosMarcados) {
        return Gerador.MARCAR_QUANTOS_NUMEROS - quantidadeDeNumerosMarcados - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA >= minimo - quantidadeDeNumerosRepetidos;
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
