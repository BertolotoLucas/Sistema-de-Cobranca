package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdaterSaldo {
    @Autowired
    ClienteService clienteService;

    public Cliente atualizaSaldo(Cliente cliente) {
        return clienteService.aualizaSaldo(cliente);
    }
}
