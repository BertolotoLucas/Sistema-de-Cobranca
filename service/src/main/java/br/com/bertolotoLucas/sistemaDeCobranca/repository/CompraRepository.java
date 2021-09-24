package br.com.bertolotoLucas.sistemaDeCobranca.repository;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {}
