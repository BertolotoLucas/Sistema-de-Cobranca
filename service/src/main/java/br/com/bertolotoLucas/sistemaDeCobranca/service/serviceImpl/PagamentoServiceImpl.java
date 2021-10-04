package br.com.bertolotoLucas.sistemaDeCobranca.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.service.PagamentoService;
import java.util.List;
import java.util.Objects;
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

    @Override
    public Pagamento delete(Pagamento p) {
        if (Objects.isNull(pagamentoRepository.findById(p.getId()))) {
            return null;
        }
        pagamentoRepository.delete(p);
        return p;
    }
}
