package br.com.bertolotoLucas.sistemaDeCobranca.domain.service.serviceImpl;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (Objects.isNull(c.getId())) return null;
        return clienteRepository.save(c);
    }

    @Override
    public List<Cliente> aualizaAllSaldo() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientesResult = new ArrayList<>();
        for (Cliente c : clientes) {
            clientesResult.add(aualizaSaldo(c));
        }
        return clientesResult;
    }

    @Override
    public Cliente aualizaSaldo(Cliente c) {
        Cliente cliente = findById(c.getId());
        if (!Objects.isNull(cliente)) {
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
        }
        return save(cliente);
    }
}
