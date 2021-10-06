package br.com.bertolotoLucas.sistemaDeCobranca.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Long count() {
        return clienteRepository.count();
    }

    @Override
    public Page<Cliente> findAll(Pageable paginacao) {
        return clienteRepository.findAll(paginacao);
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        Cliente c = null;
        if (clienteOptional.isPresent()) {
            c = clienteOptional.get();
        } else {
            throw new RuntimeException(" Cliente não encontrado id :: " + id);
        }
        return c;
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
    public void save(Cliente c) {
        clienteRepository.save(c);
    }

    @Override
    public List<Cliente> aualizaAllSaldo() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientesResult = new ArrayList<>();
        for (Cliente c : clientes) {
            clientesResult.add(atualizaSaldo(c));
        }
        return clientesResult;
    }

    @Override
    public Cliente atualizaSaldo(Cliente c) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(c.getId());
        if (!Objects.isNull(optionalCliente)) {
            Cliente cliente = optionalCliente.get();
            double result = 0;
            List<Pagamento> pagamentos = c.getPagamentos();
            for (Pagamento p : pagamentos) {
                result = result + p.getValor();
            }
            List<Compra> compras = c.getCompras();
            for (Compra caux : compras) {
                result = result - caux.getValor();
            }
            cliente.setSaldo(result);
            clienteRepository.save(cliente);
            return cliente;
        }
        return null;
    }
}
