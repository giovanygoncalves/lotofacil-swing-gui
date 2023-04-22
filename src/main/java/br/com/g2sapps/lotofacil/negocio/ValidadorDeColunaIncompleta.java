package br.com.g2sapps.lotofacil.negocio;

import br.com.g2sapps.lotofacil.dominio.Jogo;
import br.com.g2sapps.lotofacil.servico.Utilitario;

public class ValidadorDeColunaIncompleta implements Validador {

    @Override
    public boolean validar(int numeroSorteado, Jogo jogo) {
        int indiceDaColuna = Utilitario.obterIndiceDaColuna(numeroSorteado);
        return Utilitario.obterQuantidadeDeNumerosMarcadosPorColuna(jogo.getNumerosMarcados(), indiceDaColuna) < 4;
    }

}
