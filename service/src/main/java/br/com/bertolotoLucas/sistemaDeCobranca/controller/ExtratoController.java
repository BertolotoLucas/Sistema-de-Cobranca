package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtratoController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/listExtrato/{id}")
    public ModelAndView listExtrato(@PathVariable Long id) {
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            ModelAndView mv = new ModelAndView("/");
            return mv;
        }
        if (Objects.isNull(c.getPagamentos()) && Objects.isNull(c.getCompras())) {
            ModelAndView mv = new ModelAndView("extratoVazio");
            mv.addObject("cliente", c);
            return mv;
        }
        ModelAndView mv = new ModelAndView("extrato");
        mv.addObject("cliente", c);
        if (!Objects.isNull(c.getCompras())) {
            List<Compra> compras = c.getCompras();
            mv.addObject("compras", compras);
        }
        if (!Objects.isNull(c.getPagamentos())) {
            List<Pagamento> pagamentos = c.getPagamentos();
            mv.addObject("pagamentos", pagamentos);
        }
        return mv;
    }
}
