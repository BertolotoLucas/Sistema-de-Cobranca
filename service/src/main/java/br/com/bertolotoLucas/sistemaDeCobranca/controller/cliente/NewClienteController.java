package br.com.bertolotoLucas.sistemaDeCobranca.controller.cliente;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/newCliente")
    public String getClienteForm() {
        return "clienteForm";
    }

    @RequestMapping(value = "/newCliente", method = RequestMethod.POST)
    public String saveCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors() || cliente.getNome().isEmpty()) {
            return "redirect:/newCliente";
        }
        clienteService.save(cliente);
        return "redirect:/";
    }
}
