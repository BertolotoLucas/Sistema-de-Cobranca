package br.com.bertolotoLucas.sistemaDeCobranca;

import br.com.sw2you.realmeet.api.facade.PagamentoApi;
import br.com.sw2you.realmeet.api.model.Pagamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController implements PagamentoApi {

    @Override
    public CompletableFuture<ResponseEntity<Pagamento>> listPagamento(Long id) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Pagamento p = new Pagamento().id(1L).data(date).valor((float) 55.56);
        CompletableFuture<ResponseEntity<Pagamento>> completableFuture = CompletableFuture.supplyAsync(
            () -> ResponseEntity.ok(p)
        );
        return completableFuture;
    }
}
