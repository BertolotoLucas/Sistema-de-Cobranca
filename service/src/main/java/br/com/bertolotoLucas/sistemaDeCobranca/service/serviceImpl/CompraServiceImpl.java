package br.com.bertolotoLucas.sistemaDeCobranca.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.service.CompraService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public Compra findById(Long id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        if (compraOptional.isPresent()) return compraOptional.get();
        return null;
    }

    @Override
    public Compra save(Compra c) {
        return compraRepository.save(c);
    }
}
