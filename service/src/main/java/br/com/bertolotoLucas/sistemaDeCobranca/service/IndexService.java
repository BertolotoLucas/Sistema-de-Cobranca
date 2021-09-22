package br.com.bertolotoLucas.sistemaDeCobranca.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import java.util.List;

public interface IndexService {
    List<Cliente> findAll();
    Cliente findById(long id);
    Cliente save(Cliente cliente);
}
