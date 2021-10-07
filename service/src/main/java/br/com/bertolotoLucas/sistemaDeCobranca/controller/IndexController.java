package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/vazio")
    public String getNoUsers() {
        return "vazio";
    }

    @GetMapping(value = "/")
    public ModelAndView getClientes() {
        ModelAndView mv = new ModelAndView("redirect:/page1");
        return mv;
    }

    @GetMapping(value = "/page{numPage}")
    public ModelAndView getClientes(@PathVariable int numPage) {
        if (numPage < 1) {
            numPage = 1;
        } else {
            numPage = numPage - 1;
        }
        ModelAndView mv = new ModelAndView();
        double clientePerPage = 15;
        PageRequest paginacao = PageRequest.of(numPage, (int) clientePerPage);
        double totalClientes = clienteService.count();
        double totalPagesDbl = totalClientes / clientePerPage;
        int totalPages = (int) Math.ceil(totalPagesDbl);
        if (totalClientes < 1) {
            mv.setViewName("redirect:/vazio");
            return mv;
        }
        if (numPage > totalPages) {
            mv.setViewName("redirect:/page1");
            return mv;
        }
        Page<Cliente> clientes = clienteService.findAll(paginacao);
        mv = new ModelAndView("index");
        mv.addObject("clientes", clientes);
        mv.addObject("totalPages", totalPages);
        mv.addObject("actualPage", (numPage + 1));
        mv.addObject("firstPage", 1);
        return mv;
    }
    //BACKUP
    //    @GetMapping(value = "/")
    //    public ModelAndView getClientes() {
    //        List<Cliente> clientes = clienteService.findAll();
    //                if (clientes.isEmpty()) {
    //                    ModelAndView mv = new ModelAndView("vazio");
    //                    return mv;
    //                }
    //                clientes.sort(Comparator.comparing(Cliente::getSaldo));
    //            ModelAndView mv = new ModelAndView("index");
    //        mv.addObject("clientes", clientes);
    //        return mv;
    //    }
}
