package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/")
    public ModelAndView getClientes() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            ModelAndView mv = new ModelAndView("vazio");
            return mv;
        }
        //clientes.sort((c1, c2) -> c1.getNome().compareTo(c2.getNome()));
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("clientes", clientes);
        return mv;
    }
}
