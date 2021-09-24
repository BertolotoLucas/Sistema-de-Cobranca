package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {
    public String getDataFormatted(LocalDateTime data) { return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));}
    public void setData(String dataFormatted) { DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");}
}
