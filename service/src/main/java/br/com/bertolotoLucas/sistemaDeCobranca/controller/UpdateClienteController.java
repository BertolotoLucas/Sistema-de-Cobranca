package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UpdateClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/updateCliente/{id}")
    public String updateCliente(@PathVariable Long id) {
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            return "redirect:/";
        }
        c.setNome("Cliente Atualizado!");
        clienteService.save(c);
        return "redirect:/";
    }
}
