package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                for (int j = 0; j < 8; j++) {
                    Pagamento p = new Pagamento(100.00 + (double) (i * 3) / 5, LocalDateTime.now(), c);
                    pagamentos.add(p);
                    c.setSaldo(c.getSaldo() + p.getValor());
                    clienteRepository.save(c);
                }
            }
            pagamentoRepository.saveAll(pagamentos);
        }
    }
}
