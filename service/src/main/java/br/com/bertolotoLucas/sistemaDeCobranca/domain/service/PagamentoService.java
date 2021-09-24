package br.com.bertolotoLucas.sistemaDeCobranca.domain.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import java.util.List;

public interface PagamentoService {
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    Pagamento save(Pagamento p);
}
