package br.com.bertolotoLucas.sistemaDeCobranca.domain.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    List<Cliente> findAll();
    List<Cliente> findAll(Pageable paginacao);
    Cliente findById(Long id);
    void save(Cliente c);
    Cliente delete(Cliente c);
    Cliente aualizaSaldo(Cliente c);
    List<Cliente> aualizaAllSaldo();
}
