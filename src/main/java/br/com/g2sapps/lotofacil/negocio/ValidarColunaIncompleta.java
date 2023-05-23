package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Bola;
import br.com.g2sapps.lotofacil.dominio.EntidadeDeDominio;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.utilidade.UtilitarioDeColuna;

public class ValidarColunaIncompleta implements RegraDeNegocio {

    @Override
    public boolean processar(EntidadeDeDominio entidadeDeDominio) {
        Bola bolaSorteada = (Bola) entidadeDeDominio;
        int numeroSorteado = bolaSorteada.getNumero();
        Jogo jogo = bolaSorteada.getJogo();
        int indiceDaColuna = UtilitarioDeColuna.obterIndiceDaColuna(numeroSorteado);
        return UtilitarioDeColuna.obterQuantidadeDeNumerosMarcadosPorColuna(jogo.getNumerosMarcados(), indiceDaColuna) < 4;
    }

}
