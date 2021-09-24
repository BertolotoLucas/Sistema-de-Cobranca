package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class IndexController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/")
    public ModelAndView getClientes() {
        ModelAndView mv = new ModelAndView("index");
        List<Cliente> clientes = clienteService.findAll();
        mv.addObject("clientes",clientes);
        return mv;
    }

    @GetMapping(value = "/newCliente")
    public String getClienteForm() {
        return "clienteForm";
    }

    @RequestMapping(value = "/newCliente", method = RequestMethod.POST)
    public String saveCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors() || cliente.getNome().isEmpty()){
            return "redirect:/newCliente";
        }
        clienteService.save(cliente);
        return "redirect:/";
    }

    @RequestMapping(value = "/delCliente", method = RequestMethod.POST)
    public String Cliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors() || Objects.isNull(cliente)){
            return "redirect:/";
        }
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
