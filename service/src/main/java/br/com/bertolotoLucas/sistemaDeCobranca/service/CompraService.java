package br.com.bertolotoLucas.sistemaDeCobranca.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {
    List<Compra> findAll();
    Compra findById(Long id);
    Compra save(Compra c);
    Compra delete(Compra c);
}
