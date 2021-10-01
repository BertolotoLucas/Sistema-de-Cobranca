package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/")
    public ModelAndView getClientes() {
        PageRequest paginacao = PageRequest.of(0, 15);
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            ModelAndView mv = new ModelAndView("vazio");
            return mv;
        }
        clientes.sort(Comparator.comparing(Cliente::getSaldo));
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("clientes", clientes);
        return mv;
    }
}
