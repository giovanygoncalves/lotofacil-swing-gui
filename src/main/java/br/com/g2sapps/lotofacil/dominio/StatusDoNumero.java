package br.com.g2sapps.lotofacil.dominio;

public enum StatusDoNumero {

    NUMERO_NAO_SORTEADO(0), NUMERO_INVALIDO(-1), NUMERO_NAO_VALIDADO_AINDA(-2);

    private final int valor;

    private StatusDoNumero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
