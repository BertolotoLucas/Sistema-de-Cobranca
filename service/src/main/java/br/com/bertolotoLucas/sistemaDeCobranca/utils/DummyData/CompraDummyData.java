package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraDummyData {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CompraRepository compraRepository;

    //@PostConstruct
    public void saveCompras() {
        List<Cliente> clientes;
        clientes = clienteRepository.findAll();
        if (!clientes.isEmpty()) {
            List<Compra> compras = new ArrayList<>();
            int i = 0;
            for (Cliente c : clientes) {
                i++;
                for (int j = 0; j < 15; j++) {
                    Compra caux = new Compra(
                        100.00,
                        LocalDateTime.now().plusSeconds(j + i),
                        "Comprou muitas coisas",
                        c
                    );
                    compras.add(caux);
                    c.setSaldo(c.getSaldo() - caux.getValor());
                    clienteRepository.save(c);
                }
            }
            compraRepository.saveAll(compras);
        }
    }
}
