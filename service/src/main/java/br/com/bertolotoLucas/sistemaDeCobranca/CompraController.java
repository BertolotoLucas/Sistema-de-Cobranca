package br.com.bertolotoLucas.sistemaDeCobranca;

import br.com.sw2you.realmeet.api.facade.CompraApi;
import br.com.sw2you.realmeet.api.model.Compra;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController implements CompraApi {

    @Override
    public CompletableFuture<ResponseEntity<Compra>> listCompra(Long id) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Compra c = new Compra().id(1L).data(date).descricao("Duas camisas regatas").valor((float) 87.30);
        CompletableFuture<ResponseEntity<Compra>> completableFuture = CompletableFuture.supplyAsync(
            () -> ResponseEntity.ok(c)
        );
        return completableFuture;
    }
}
