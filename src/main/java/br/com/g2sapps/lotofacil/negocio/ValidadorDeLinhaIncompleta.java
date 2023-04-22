package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.servico.Utilitario;

public class ValidadorDeLinhaIncompleta implements Validador {

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        int indiceDaLinha = Utilitario.obterIndiceDaLinha(numeroSorteado);
        return Utilitario.obterQuantidadeDeNumerosMarcadosPorLinha(jogo.getNumerosMarcados(), indiceDaLinha) < 4;
    }

}
