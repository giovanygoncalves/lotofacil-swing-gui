package br.com.g2sapps.lotofacil.dominio;

import java.util.ArrayList;
import java.util.List;

public class Globo {

    private final List<Bola> bolas;

    public Globo() {
        bolas = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            bolas.add(new Bola(i + 1));
        }
    }

    public List<Bola> getBolas() {
        return bolas;
    }

}
