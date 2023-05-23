package br.com.g2sapps.lotofacil.dominio;

import java.util.List;
import java.util.NoSuchElementException;
import br.com.g2sapps.lotofacil.negocio.RegraDeNegocio;

public class Gerador {

    public static final int MARCAR_QUANTOS_NUMEROS = 15;
    private final Jogo jogo;
    private final Globo globo;

    public Gerador() {
        jogo = new Jogo();
        globo = new Globo();
    }

    public Jogo gerarJogo(List<RegraDeNegocio> regrasDeNegocio) {
        while (jogo.obterQuantidadeDeNumerosMarcados() < MARCAR_QUANTOS_NUMEROS) {
            Bola bolaSorteada = sortearBola();
            bolaSorteada.setJogo(jogo);
            removerBola(bolaSorteada);
            int numeroSorteado = bolaSorteada.getNumero();
            jogo.sinalizarNumeroNaoValidadoAinda(numeroSorteado);
            boolean numeroValido = true;
            for (RegraDeNegocio regraDeNegocio : regrasDeNegocio) {
                if (!regraDeNegocio.processar(bolaSorteada)) {
                    numeroValido = false;
                    break;
                }
            }
            if (numeroValido) {
                jogo.marcarNumero(numeroSorteado);
            } else {
                jogo.sinalizarNumeroInvalido(numeroSorteado);
            }
        }
        return jogo;
    }

    private Bola sortearBola() {
        int indice = (int) (Math.random() * globo.getBolas().size());
        return globo.getBolas().get(indice);
    }

    public void fixarNumeros(List<Integer> numeros) {
        for (Integer numero : numeros) {
            fixarNumero(numero);
        }
    }

    public void fixarNumero(int numero) {
        removerNumero(numero);
        jogo.marcarNumero(numero);
    }

    public void removerNumeros(List<Integer> numeros) {
        for (Integer numero : numeros) {
            removerNumero(numero);
        }
    }

    public void removerNumero(int numero) {
        Bola bola = obterBola(numero);
        removerBola(bola);
        jogo.sinalizarNumeroInvalido(numero);
    }

    private Bola obterBola(int numero) throws NoSuchElementException {
        for (Bola bola : globo.getBolas()) {
            if (bola.getNumero() == numero) {
                return bola;
            }
        }
        throw new NoSuchElementException();
    }

    private boolean removerBola(Bola bola) {
        return globo.getBolas().remove(bola);
    }

}
