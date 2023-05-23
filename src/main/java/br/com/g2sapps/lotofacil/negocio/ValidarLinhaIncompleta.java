package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Bola;
import br.com.g2sapps.lotofacil.dominio.EntidadeDeDominio;
import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.utilidade.UtilitarioDeLinha;

public class ValidarLinhaIncompleta implements RegraDeNegocio {

    @Override
    public boolean processar(EntidadeDeDominio entidadeDeDominio) {
        Bola bolaSorteada = (Bola) entidadeDeDominio;
        int numeroSorteado = bolaSorteada.getNumero();
        Jogo jogo = bolaSorteada.getJogo();
        int indiceDaLinha = UtilitarioDeLinha.obterIndiceDaLinha(numeroSorteado);
        return UtilitarioDeLinha.obterQuantidadeDeNumerosMarcadosPorLinha(jogo.getNumerosMarcados(), indiceDaLinha) < 4;
    }

}
