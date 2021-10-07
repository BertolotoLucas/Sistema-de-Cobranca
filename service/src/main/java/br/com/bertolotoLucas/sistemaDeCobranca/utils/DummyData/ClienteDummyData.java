package br.com.bertolotoLucas.sistemaDeCobranca.utils.DummyData;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteDummyData {
    @Autowired
    ClienteRepository clienteRepository;

    //@PostConstruct
    public void saveClientes() {
        List<Cliente> clientes = new ArrayList<>();
        //        for (int i = 1; i < 100; i++) {
        //            clientes.add(new Cliente("Cliente #" + i, 0));
        //        }
        clientes.add(new Cliente("Francisco Xavier"));
        clientes.add(new Cliente("Juliana Fernandes"));
        clientes.add(new Cliente("Debora Nascimento"));
        clientes.add(new Cliente("João Luis"));
        clientes.add(new Cliente("Fernando Ribeiro"));
        clientes.add(new Cliente("Catarina Fernades"));
        clientes.add(new Cliente("Lucas Bertoloto"));
        clientes.add(new Cliente("Fernando Alencar"));
        clientes.add(new Cliente("Lucas Motoso"));
        clientes.add(new Cliente("Cleverson Lira"));
        clientes.add(new Cliente("Bruno Eduardo"));
        clientes.add(new Cliente("Jhone"));
        clientes.add(new Cliente("Heder Alves"));
        clientes.add(new Cliente("Dener Ventura"));
        clientes.add(new Cliente("Marcos Vinicius"));
        clientes.add(new Cliente("Henrique de Andrade"));
        clientes.add(new Cliente("Pedro Marins"));
        clientes.forEach(c -> c.setCelular("(21) 99999-9999"));
        clienteRepository.saveAll(clientes);
    }
}
