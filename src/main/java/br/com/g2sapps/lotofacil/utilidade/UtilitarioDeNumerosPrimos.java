package br.com.g2sapps.lotofacil.utilidade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class UtilitarioDeNumerosPrimos {

    private static final List<Integer> NUMEROS_PRIMOS_DE_1_A_25;

    static {
        NUMEROS_PRIMOS_DE_1_A_25 = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));
    }

    private UtilitarioDeNumerosPrimos() {
    }

    public static boolean ehPrimo(int numero) {
        return NUMEROS_PRIMOS_DE_1_A_25.contains(numero);
    }

}
