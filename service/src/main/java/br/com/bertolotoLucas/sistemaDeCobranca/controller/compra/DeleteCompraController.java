package br.com.bertolotoLucas.sistemaDeCobranca.controller.compra;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.CompraService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteCompraController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CompraService compraService;

    @GetMapping("/{idCliente}/deleteCompra/{id}")
    public String deleteCompra(@PathVariable Long idCliente, @PathVariable Long id) {
        if (Objects.isNull(clienteService.findById(idCliente))) {
            return "redirect:/";
        }
        if (Objects.isNull(compraService.findById(id))) {
            return "redirect:/listExtrato/" + idCliente;
        }
        Compra deletedCompra = null;
        deletedCompra = compraService.delete(compraService.findById(id));
        Cliente cliente = deletedCompra.getCliente();
        cliente.getCompras().remove(deletedCompra);
        clienteService.atualizaSaldo(cliente);
        return "redirect:/listExtrato/" + deletedCompra.getCliente().getId().toString();
    }
}
