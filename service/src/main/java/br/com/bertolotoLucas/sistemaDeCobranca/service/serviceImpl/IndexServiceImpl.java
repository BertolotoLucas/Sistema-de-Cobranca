package br.com.bertolotoLucas.sistemaDeCobranca.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.service.IndexService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente findById(long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
