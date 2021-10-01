package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.utils.Extrato;
import java.util.*;
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
        //Preciso implementar uma pagina vazia caso o cliente nao tenha compras ou pagamentos
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
            for (Compra caux : compras) {
                extratos.add(new Extrato("compra", -caux.getValor(), caux.getData()));
            }
            for (Pagamento paux : pagamentos) {
                extratos.add(new Extrato("pagamento", paux.getValor(), paux.getData()));
            }
            extratos.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
        } else {
            if (!Objects.isNull(c.getCompras())) {
                List<Compra> compras = c.getCompras();
                compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
                for (Compra caux : compras) {
                    extratos.add(new Extrato("compra", -caux.getValor(), caux.getData()));
                }
            }
            if (!Objects.isNull(c.getPagamentos())) {
                List<Pagamento> pagamentos = c.getPagamentos();
                pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
                for (Pagamento paux : pagamentos) {
                    extratos.add(new Extrato("pagamento", paux.getValor(), paux.getData()));
                }
            }
        }
        Collections.reverse(extratos);
        mv.addObject("extratos", extratos);
        return mv;
    }
}
