package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
                compras.add(new Compra(-200 + (i * 3), LocalDateTime.now(), "Camisa #" + i, c));
            }
            compraRepository.saveAll(compras);
        }
    }
}
