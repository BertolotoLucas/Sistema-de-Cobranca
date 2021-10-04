package br.com.bertolotoLucas.sistemaDeCobranca.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PagamentoService {
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    Pagamento save(Pagamento p);
    Pagamento delete(Pagamento p);
}
