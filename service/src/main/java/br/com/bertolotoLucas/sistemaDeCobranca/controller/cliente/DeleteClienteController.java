package br.com.bertolotoLucas.sistemaDeCobranca.controller.cliente;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/deleteCliente/{id}")
    public String deletarCliente(@PathVariable Long id) {
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            return "redirect:/";
        }
        clienteService.delete(c);
        return "redirect:/";
    }
}
