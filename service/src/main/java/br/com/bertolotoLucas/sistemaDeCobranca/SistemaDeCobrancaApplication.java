package br.com.bertolotoLucas.sistemaDeCobranca;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaDeCobrancaApplication {

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("net START MySQL80");
        SpringApplication.run(SistemaDeCobrancaApplication.class, args);
    }
}
