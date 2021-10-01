package br.com.bertolotoLucas.sistemaDeCobranca.controller.cliente;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/newClienteForm")
    public ModelAndView getClienteForm() {
        ModelAndView mv = new ModelAndView("clienteForm").addObject("cliente", new Cliente());
        return mv;
    }

    @PostMapping(value = "/saveCliente")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        if (cliente.getNome().isEmpty()) {
            return "redirect:/clienteForm";
        }
        clienteService.save(cliente);
        return "redirect:/";
    }
}
