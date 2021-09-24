package br.com.bertolotoLucas.sistemaDeCobranca;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.ClienteRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.CompraRepository;
import br.com.bertolotoLucas.sistemaDeCobranca.repository.PagamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SistemaDeCobrancaApplication implements CommandLineRunner {
    private ClienteRepository clienteRepository;
    private CompraRepository compraRepository;
    private PagamentoRepository pagamentoRepository;

    public SistemaDeCobrancaApplication(ClienteRepository clienteRepository, CompraRepository compraRepository,
                                        PagamentoRepository pagamentoRepository){
        this.clienteRepository = clienteRepository;
        this.compraRepository = compraRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SistemaDeCobrancaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //Cliente c = new Cliente("Cliente1",-55.80);
        //System.out.println(c);
        //testarClienteRepository(c);

        //testarCompraRepository();
        //System.out.println("Deletando todos os clientes novamente");
        //this.clienteRepository.deleteAll();
        //System.out.println("Clientes Deletados!");

        //testarPagamentoRepository();
        //System.out.println("Deletando todos os clientes novamente");
        //this.clienteRepository.deleteAll();
        //System.out.println("Clientes Deletados!");
    }

    @Transactional
    private void testarPagamentoRepository() {
        Cliente c;
        System.out.println("Testando o PagamentoRepository function: ");
        System.out.println("Criando clientes no BD: ");
        c = new Cliente("Cliente1", -48);
        Cliente c2 = new Cliente("Cliente2", -47);
        Cliente c3 = new Cliente("Cliente3", -46);
        Cliente c4 = new Cliente("Cliente4", -45);
        Cliente c5 = new Cliente("Cliente5", -44);
        Cliente c6 = new Cliente("Cliente6", -43);
        Cliente c7 = new Cliente("Cliente7", -42);
        this.clienteRepository.save(c);
        this.clienteRepository.save(c2);
        this.clienteRepository.save(c3);
        this.clienteRepository.save(c4);
        this.clienteRepository.save(c5);
        this.clienteRepository.save(c6);
        this.clienteRepository.save(c7);
        System.out.println("Clientes criados no BD: ");
        clienteRepository.findAll().forEach(System.out::println);
        System.out.println("Criando classes de pagamento");
        Pagamento pg = new Pagamento(15, LocalDateTime.now(), c);
        //System.out.println("Data que esta sendo enviada para o banco: "+cp.getData());
        Pagamento pg1 = new Pagamento(15, LocalDateTime.now(), c2);
        Pagamento pg2 = new Pagamento(15, LocalDateTime.now(), c3);
        Pagamento pg3 = new Pagamento(15, LocalDateTime.now(), c4);
        Pagamento pg4 = new Pagamento(15, LocalDateTime.now(), c5);
        Pagamento pg5 = new Pagamento(15, LocalDateTime.now(), c6);
        Pagamento pg6 = new Pagamento(15, LocalDateTime.now(), c7);
        this.pagamentoRepository.save(pg);
        this.pagamentoRepository.save(pg1);
        this.pagamentoRepository.save(pg2);
        this.pagamentoRepository.save(pg3);
        this.pagamentoRepository.save(pg4);
        this.pagamentoRepository.save(pg5);
        this.pagamentoRepository.save(pg6);
        System.out.println("Todos os pagamentos foram colocadas no BD, vamos mostrar todos: ");
        List<Pagamento> pagamentos = this.pagamentoRepository.findAll();
        pagamentos.forEach(System.out::println);
        System.out.println("Vou excluir um pagamento com id 1L");
        Optional<Pagamento> optionalPagamento = this.pagamentoRepository.findById(1L);
        if(optionalPagamento.isPresent()) {
            System.out.println("Encontrado o pagamento");
            Pagamento pgaux = optionalPagamento.get();
            this.pagamentoRepository.delete(pgaux);
            System.out.println("Pagamento deletado:" + pgaux);

        } else {
            System.out.println("Pagamento com id 1 nao foi encontrado");
        }

        System.out.println("Vou excluir todos os pagamentos");
        this.pagamentoRepository.deleteAll();
        System.out.println("Todos os pagamentos deletados");
    }

    @Transactional
    private void testarCompraRepository() {
        Cliente c;
        System.out.println("Testando o CompraRepository function: ");
        System.out.println("Criando clientes no BD: ");
        c = new Cliente("Cliente1", -48);
        Cliente c2 = new Cliente("Cliente2", -47);
        Cliente c3 = new Cliente("Cliente3", -46);
        Cliente c4 = new Cliente("Cliente4", -45);
        Cliente c5 = new Cliente("Cliente5", -44);
        Cliente c6 = new Cliente("Cliente6", -43);
        Cliente c7 = new Cliente("Cliente7", -42);
        this.clienteRepository.save(c);
        this.clienteRepository.save(c2);
        this.clienteRepository.save(c3);
        this.clienteRepository.save(c4);
        this.clienteRepository.save(c5);
        this.clienteRepository.save(c6);
        this.clienteRepository.save(c7);
        System.out.println("Clientes criados no BD: ");
        clienteRepository.findAll().forEach(System.out::println);
        System.out.println("Criando classes de compra");
        Compra cp = new Compra(15, LocalDateTime.now(), "2 chinelos", c);
        //System.out.println("Data que esta sendo enviada para o banco: "+cp.getData());
        Compra cp1 = new Compra(15, LocalDateTime.now(), "2 chinelos", c2);
        Compra cp2 = new Compra(15, LocalDateTime.now(), "2 chinelos", c3);
        Compra cp3 = new Compra(15, LocalDateTime.now(), "2 chinelos", c4);
        Compra cp4 = new Compra(15, LocalDateTime.now(), "2 chinelos", c5);
        Compra cp5 = new Compra(15, LocalDateTime.now(), "2 chinelos", c6);
        Compra cp6 = new Compra(15, LocalDateTime.now(), "2 chinelos", c7);
        this.compraRepository.save(cp);
        this.compraRepository.save(cp1);
        this.compraRepository.save(cp2);
        this.compraRepository.save(cp3);
        this.compraRepository.save(cp4);
        this.compraRepository.save(cp5);
        this.compraRepository.save(cp6);
        System.out.println("Todas as compras foram colocadas no BD, vamos mostrar todas: ");
        List<Compra> compras = this.compraRepository.findAll();
        for(Compra cpx:compras) {
            System.out.println(cpx);
        }
        System.out.println("Vou excluir uma compra com id 1L");
        Optional<Compra> optionalCompra = this.compraRepository.findById(1L);
        if(optionalCompra.isPresent()) {
            System.out.println("Encontrado a compra");
            Compra cpaux = optionalCompra.get();
            this.compraRepository.delete(cpaux);
            System.out.println("Compra deletada:" + cpaux);

        } else {
            System.out.println("Compra com id 1 nao foi encontrada");
        }

        System.out.println("Vou excluir todas as compras");
        this.compraRepository.deleteAll();
        System.out.println("Todas as compras deletadas");
    }

    @Transactional
    private void testarClienteRepository(Cliente c) {
        this.clienteRepository.save(c);
        System.out.println(c);
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(c.getId());
        if(optionalCliente.isPresent()) {
            c = optionalCliente.get();
            System.out.println("Cliente encontrado: "+ c);
            c.setNome("Cliente1 Atualizado!");
            c.setSaldo(0);
            System.out.println("Cliente atualizado a ser mandado para o banco: "+ c);
            this.clienteRepository.save(c);
            System.out.println("Cliente atualizado no banco: "+ c);

            System.out.println("Será adicionado varios clientes para testar o delete");

            this.clienteRepository.save(new Cliente("Carlos", -15));
            this.clienteRepository.save(new Cliente("Beto", -1));
            this.clienteRepository.save(new Cliente("Daniel", 0));
            this.clienteRepository.save(new Cliente("Francisco", 0));
            this.clienteRepository.save(new Cliente("Sidney", -2000));
            this.clienteRepository.save(new Cliente("Carol", -48));

            List<Cliente> all = this.clienteRepository.findAll();
            System.out.println("Todos os clientes cadastrados: ");
            for (Cliente c1 : all) {
                System.out.println(c1);
            }
            System.out.println("Irei excluir um cliente de id 1 se existir: ");
            Optional<Cliente> optional = this.clienteRepository.findById(1L);
            if(optional.isPresent()) {
                Cliente c2 = optional.get();
                this.clienteRepository.delete(c2);
                System.out.println("Cliente removido: "+c2);
            } else {
                System.out.println("Nao foi encontrado");
            }
            System.out.println("Agora todos os clientes serao removidos: ");
            this.clienteRepository.deleteAll();
            System.out.println("Isso e tudo pessoal!");

        } else {
            System.out.println("Id invalido!");
        }
    }
}
