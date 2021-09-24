package br.com.bertolotoLucas.sistemaDeCobranca.repository;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
