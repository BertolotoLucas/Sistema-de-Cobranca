package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteDummyData {
    @Autowired
    ClienteRepository clienteRepository;

    //@PostConstruct
    public void saveClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            clientes.add(new Cliente("Cliente #" + i, -200 + (i * 3)));
        }
        clienteRepository.saveAll(clientes);
    }
}
