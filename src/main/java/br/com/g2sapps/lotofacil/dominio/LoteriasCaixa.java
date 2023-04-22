package br.com.g2sapps.lotofacil.dominio;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoteriasCaixa {

    public static List<Integer> obterNumerosSorteadosNoUltimoConcurso() throws Exception {
        List<Integer> numerosSorteadosNoUltimoConcurso = new ArrayList<>();
        Document document = Jsoup.connect("https://noticias.uol.com.br/loterias/lotofacil/").get();
        Elements elements = document.select(".lt-number");
        for (Element element : elements) {
            numerosSorteadosNoUltimoConcurso.add(Integer.valueOf(element.text()));
        }
        return numerosSorteadosNoUltimoConcurso;
    }

}
