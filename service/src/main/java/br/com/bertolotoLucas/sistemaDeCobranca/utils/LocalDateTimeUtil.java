package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeUtil {

    public static LocalDateTime retirarOsSegundos(LocalDateTime localDateTime) {
        return localDateTime.truncatedTo(ChronoUnit.MINUTES);
    }
}
