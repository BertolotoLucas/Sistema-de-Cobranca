package br.com.bertolotoLucas.sistemaDeCobranca.domain.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.PagamentoService;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Pagamento findById(Long id) {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);
        if (pagamentoOptional.isPresent()) return pagamentoOptional.get();
        return null;
    }

    @Override
    public Pagamento save(Pagamento p) {
        return pagamentoRepository.save(p);
    }
}
