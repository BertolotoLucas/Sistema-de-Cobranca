//package br.com.bertolotoLucas.sistemaDeCobranca.utils;
//
//import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
//import br.com.bertolotoLucas.sistemaDeCobranca.domain.repository.ClienteRepository;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DummyData {
//    @Autowired
//    ClienteRepository clienteRepository;
//
//    @PostConstruct
//    public void saveClientes() {
//        List<Cliente> clienteList = new ArrayList<Cliente>();
//        Cliente c1 = Cliente.newBuilder().id(1L).nome("Franciso").valorPendente((float) 58.00).build();
//        Cliente c2 = Cliente.newBuilder().id(2L).nome("Franciso2").valorPendente((float) 58.00).build();
//        Cliente c3 = Cliente.newBuilder().id(3L).nome("Franciso3").valorPendente((float) 58.00).build();
//        Cliente c4 = Cliente.newBuilder().id(4L).nome("Franciso4").valorPendente((float) 58.00).build();
//        Cliente c5 = Cliente.newBuilder().id(5L).nome("Franciso5").valorPendente((float) 58.00).build();
//
//        clienteList.add(c1);
//        clienteList.add(c2);
//        clienteList.add(c3);
//        clienteList.add(c4);
//        clienteList.add(c5);
//
//        for (Cliente c : clienteList) {
//            Cliente clienteSaved = clienteRepository.save(c);
//            System.out.println(clienteSaved.getId());
//        }
//    }
//}
