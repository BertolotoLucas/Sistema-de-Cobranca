package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PagamentoDummyData {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PagamentoRepository pagamentoRepository;

    //@PostConstruct
    public void saveCompras() {
        List<Cliente> clientes;
        clientes = clienteRepository.findAll();
        if (!clientes.isEmpty()) {
            List<Pagamento> pagamentos = new ArrayList<>();
            int i = 0;
            for (Cliente c : clientes) {
                i++;
                pagamentos.add(new Pagamento(-200 + (i * 3), LocalDateTime.now(), c));
            }
            pagamentoRepository.saveAll(pagamentos);
        }
    }
}
