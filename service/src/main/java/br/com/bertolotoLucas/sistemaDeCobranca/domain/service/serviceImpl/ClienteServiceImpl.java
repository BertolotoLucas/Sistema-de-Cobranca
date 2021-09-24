package br.com.bertolotoLucas.sistemaDeCobranca.domain.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) return clienteOptional.get();
        return null;
    }

    @Override
    public Cliente delete(Cliente c) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(c.getId());
        if (clienteOptional.isPresent()) {
            clienteRepository.delete(c);
            return clienteOptional.get();
        }
        return null;
    }

    @Override
    public Cliente save(Cliente c) {
        return clienteRepository.save(c);
    }
}
