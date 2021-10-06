package br.com.bertolotoLucas.sistemaDeCobranca.utils;

public class Matcher {
    private static final String PATTERN_CELULAR = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}";

    public boolean matchCelular(String celular) {
        return celular.matches(PATTERN_CELULAR);
    }
}
