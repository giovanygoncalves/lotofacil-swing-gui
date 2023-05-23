package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Bola;
import br.com.g2sapps.lotofacil.dominio.EntidadeDeDominio;
import br.com.g2sapps.lotofacil.dominio.Gerador;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.utilidade.UtilitarioDeNumerosPrimos;

public class ValidarNumerosPrimos extends ValidarBolaSorteada {

    private int minimo;
    private int maximo;

    public ValidarNumerosPrimos() {
        minimo = 4;
        maximo = 6;
    }

    public ValidarNumerosPrimos(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean processar(EntidadeDeDominio entidadeDeDominio) {
        Bola bolaSorteada = (Bola) entidadeDeDominio;
        int numeroSorteado = bolaSorteada.getNumero();
        Jogo jogo = bolaSorteada.getJogo();
        int quantidadeDeNumerosPrimos = UtilitarioDeNumerosPrimos.ehPrimo(numeroSorteado) ? 1 : 0;
        for (Integer numerosMarcado : jogo.getListaDeNumerosMarcados()) {
            if (UtilitarioDeNumerosPrimos.ehPrimo(numerosMarcado)) {
                quantidadeDeNumerosPrimos++;
            }
        }
        return (quantidadeDeNumerosPrimos >= minimo || minimoAindaPodeSerAtingido(quantidadeDeNumerosPrimos, jogo.obterQuantidadeDeNumerosMarcados())) && quantidadeDeNumerosPrimos <= maximo;
    }

    private boolean minimoAindaPodeSerAtingido(int quantidadeDeNumerosPrimos, int quantidadeDeNumerosMarcados) {
        return Gerador.MARCAR_QUANTOS_NUMEROS - quantidadeDeNumerosMarcados - QUANTIDADE_DE_NUMEROS_SENDO_VALIDADA >= minimo - quantidadeDeNumerosPrimos;
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
