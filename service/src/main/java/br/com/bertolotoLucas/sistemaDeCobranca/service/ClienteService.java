package br.com.bertolotoLucas.sistemaDeCobranca.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Long count();
    List<Cliente> findAll();
    Page<Cliente> findAll(Pageable paginacao);
    Cliente findById(Long id);
    void save(Cliente c);
    Cliente delete(Cliente c);
    Cliente atualizaSaldo(Cliente c);
    List<Cliente> aualizaAllSaldo();
}
