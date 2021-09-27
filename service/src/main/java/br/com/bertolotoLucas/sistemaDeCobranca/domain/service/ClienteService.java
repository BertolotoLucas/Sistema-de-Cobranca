package br.com.bertolotoLucas.sistemaDeCobranca.domain.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente c);
    Cliente delete(Cliente c);
    Cliente aualizaSaldo(Cliente c);
    List<Cliente> aualizaAllSaldo();
}
