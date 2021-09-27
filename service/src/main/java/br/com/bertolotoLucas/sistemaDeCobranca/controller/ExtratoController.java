package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.bertolotoLucas.sistemaDeCobranca.utils.Extrato;
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
        List<Extrato> extratos = new ArrayList<>();
        if (!Objects.isNull(c.getCompras()) && !Objects.isNull(c.getPagamentos())) {
            List<Compra> compras = c.getCompras();
            compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
            List<Pagamento> pagamentos = c.getPagamentos();
            pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
            for (int i = 0; (i < compras.size()) && (i < pagamentos.size()); i++) {
                Extrato e = new Extrato();
                if (!Objects.isNull(compras.get(i))) e.setCompra(compras.get(i));
                if (!Objects.isNull(pagamentos.get(i))) e.setPagamento(pagamentos.get(i));
                extratos.add(e);
            }
            extratos.sort((e1, e2) -> {
                if (!Objects.isNull(e1.getCompra()) && !Objects.isNull(e2.getPagamento())) {
                    return e1.getCompra().getData().compareTo(e2.getPagamento().getData());
                } else {
                    if (Objects.isNull(e1.getCompra())) {
                        if (!Objects.isNull(e2.getPagamento())) {
                            return e1.getPagamento().getData().compareTo(e2.getPagamento().getData());
                        } else {
                            return e1.getPagamento().getData().compareTo(e2.getCompra().getData());
                        }
                    }
                    if (Objects.isNull(e2.getPagamento())) {
                        return e1.getCompra().getData().compareTo(e2.getCompra().getData());
                    }
                }
                return 0;
            });
            mv.addObject("extratos", extratos);
        } else {
            if (!Objects.isNull(c.getCompras())) {
                List<Compra> compras = c.getCompras();
                mv.addObject("compras", compras);
            }
            if (!Objects.isNull(c.getPagamentos())) {
                List<Pagamento> pagamentos = c.getPagamentos();
                mv.addObject("pagamentos", pagamentos);
            }
        }
        return mv;
    }
}
