package br.com.g2sapps.lotofacil.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NumerosPrimos {

    private static final List<Integer> NUMEROS_PRIMOS_DE_1_A_25;

    static {
        NUMEROS_PRIMOS_DE_1_A_25 = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));
    }

    public static List<Integer> obterNumerosPrimosDe1A25() {
        return NUMEROS_PRIMOS_DE_1_A_25;
    }

}
