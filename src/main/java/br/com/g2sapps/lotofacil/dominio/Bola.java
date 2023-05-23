package br.com.g2sapps.lotofacil.dominio;

public class Bola extends EntidadeDeDominio {

    private int numero;
    private Jogo jogo;

    public Bola(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

}
