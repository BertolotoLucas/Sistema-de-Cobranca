package br.com.bertolotoLucas.sistemaDeCobranca.domain.service;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;

import java.util.List;

public interface CompraService {
    List<Compra> findAll();
    Compra findById(Long id);
    Compra save(Compra c);
}
