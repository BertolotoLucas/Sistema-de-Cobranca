package br.com.bertolotoLucas.sistemaDeCobranca.repository;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {}
