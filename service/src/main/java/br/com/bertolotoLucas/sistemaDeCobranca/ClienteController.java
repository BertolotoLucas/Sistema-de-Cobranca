package br.com.bertolotoLucas.sistemaDeCobranca;

import br.com.sw2you.realmeet.api.facade.ClienteApi;
import br.com.sw2you.realmeet.api.model.Cliente;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController implements ClienteApi {

    @Override
    public CompletableFuture<ResponseEntity<Cliente>> listCliente(Long id) {
        Cliente c = new Cliente().id(1L).nome("Carlos").valorPendente((float) 256.87);
        CompletableFuture<ResponseEntity<Cliente>> completableFuture = CompletableFuture.supplyAsync(
            () -> ResponseEntity.ok(c)
        );
        return completableFuture;
    }
}
