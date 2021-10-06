package br.com.bertolotoLucas.sistemaDeCobranca.controller.pagamento;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.PagamentoService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeletePagamentoController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    PagamentoService PagamentoService;

    @GetMapping("/{idCliente}/deletePagamento/{id}")
    public String deletePagamento(@PathVariable Long idCliente, @PathVariable Long id) {
        if (Objects.isNull(clienteService.findById(idCliente))) {
            return "redirect:/";
        }
        if (Objects.isNull(PagamentoService.findById(id))) {
            return "redirect:/listExtrato/" + idCliente;
        }
        Pagamento deletedPagamento = null;
        deletedPagamento = PagamentoService.delete(PagamentoService.findById(id));
        Cliente cliente = deletedPagamento.getCliente();
        cliente.getPagamentos().remove(deletedPagamento);
        clienteService.atualizaSaldo(cliente);
        return "redirect:/listExtrato/" + deletedPagamento.getCliente().getId().toString();
    }
}
