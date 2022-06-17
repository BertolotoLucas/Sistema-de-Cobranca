package br.com.bertolotoLucas.sistemaDeCobranca.controller;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.utils.Extrato;
import java.util.*;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        if (Objects.isNull(clienteService.findById(id))) {
            ModelAndView mv = new ModelAndView("redirect:/");
            return mv;
        }
        ModelAndView mv = new ModelAndView("redirect:/listExtrato/" + id + "/page1");
        return mv;
    }

    @GetMapping(value = "/listExtrato/{id}/page{numPage}")
    public ModelAndView listExtrato(@PathVariable Long id, @PathVariable int numPage) {
        if (numPage < 1) {
            numPage = 1;
        } else {
            numPage = numPage - 1;
        }
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            ModelAndView mv = new ModelAndView("redirect:/");
            return mv;
        }
        if (c.getPagamentos().isEmpty() && c.getCompras().isEmpty()) {
            ModelAndView mv = new ModelAndView("extratoVazio");
            mv.addObject("cliente", c);
            return mv;
        }
        ModelAndView mv = new ModelAndView("extrato");
        mv.addObject("cliente", c);
        List<Extrato> extratos = new ArrayList<>();
        if (!c.getCompras().isEmpty() && !c.getPagamentos().isEmpty()) {
            List<Compra> compras = c.getCompras();
            compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
            List<Pagamento> pagamentos = c.getPagamentos();
            pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
            for (Compra caux : compras) {
                Extrato extrato = new Extrato("Compra", -caux.getValor(), caux.getData());
                extrato.setIdCompra(caux.getId());
                extratos.add(extrato);
            }
            for (Pagamento paux : pagamentos) {
                Extrato extrato = new Extrato("Pagamento", paux.getValor(), paux.getData());
                extrato.setIdPagamento(paux.getId());
                extratos.add(extrato);
            }
            extratos.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
        } else {
            if (!c.getCompras().isEmpty()) {
                List<Compra> compras = c.getCompras();
                compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
                for (Compra caux : compras) {
                    Extrato extrato = new Extrato("Compra", -caux.getValor(), caux.getData());
                    extrato.setIdCompra(caux.getId());
                    extratos.add(extrato);
                }
            }
            if (!c.getPagamentos().isEmpty()) {
                List<Pagamento> pagamentos = c.getPagamentos();
                pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
                for (Pagamento paux : pagamentos) {
                    Extrato extrato = new Extrato("Pagamento", paux.getValor(), paux.getData());
                    extrato.setIdPagamento(paux.getId());
                    extratos.add(extrato);
                }
            }
        }
        Collections.reverse(extratos);
        long totalExtratos = extratos.size();
        double extratoPerPage = 15;
        PageRequest paginacao = PageRequest.of(numPage, (int) extratoPerPage);
        double totalPagesDbl = totalExtratos / extratoPerPage;
        int totalPages = (int) Math.ceil(totalPagesDbl);
        if (numPage > totalPages) {
            mv.setViewName("redirect:/listExtrato/" + id + "page1");
            return mv;
        }
        //Converting ArrayList to Page
        final int start = (int) paginacao.getOffset();
        final int end = Math.min((start + paginacao.getPageSize()), extratos.size());
        final Page<Extrato> page = new PageImpl<>(extratos.subList(start, end), paginacao, extratos.size());

        mv.addObject("extratos", page);
        mv.addObject("cliente", c);
        mv.addObject("totalPages", totalPages);
        mv.addObject("actualPage", (numPage + 1));
        mv.addObject("firstPage", 1);
        return mv;
    }
    //BACKUP
    //    @GetMapping(value = "/listExtrato/{id}/")
    //    public ModelAndView listExtrato(@PathVariable Long id) {
    //        Cliente c = clienteService.findById(id);
    //        if (Objects.isNull(c)) {
    //            ModelAndView mv = new ModelAndView("/");
    //            return mv;
    //        }
    //        if (c.getPagamentos().isEmpty() && c.getCompras().isEmpty()) {
    //            ModelAndView mv = new ModelAndView("extratoVazio");
    //            mv.addObject("cliente", c);
    //            return mv;
    //        }
    //        ModelAndView mv = new ModelAndView("extrato");
    //        mv.addObject("cliente", c);
    //        List<Extrato> extratos = new ArrayList<>();
    //        if (!c.getCompras().isEmpty() && !c.getPagamentos().isEmpty()) {
    //            List<Compra> compras = c.getCompras();
    //            compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
    //            List<Pagamento> pagamentos = c.getPagamentos();
    //            pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
    //            for (Compra caux : compras) {
    //                Extrato extrato = new Extrato("compra", -caux.getValor(), caux.getData());
    //                extrato.setIdCompra(caux.getId());
    //                extratos.add(extrato);
    //            }
    //            for (Pagamento paux : pagamentos) {
    //                Extrato extrato = new Extrato("pagamento", paux.getValor(), paux.getData());
    //                extrato.setIdPagamento(paux.getId());
    //                extratos.add(extrato);
    //            }
    //            extratos.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
    //        } else {
    //            if (!c.getCompras().isEmpty()) {
    //                List<Compra> compras = c.getCompras();
    //                compras.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));
    //                for (Compra caux : compras) {
    //                    Extrato extrato = new Extrato("compra", -caux.getValor(), caux.getData());
    //                    extrato.setIdCompra(caux.getId());
    //                    extratos.add(extrato);
    //                }
    //            }
    //            if (!c.getPagamentos().isEmpty()) {
    //                List<Pagamento> pagamentos = c.getPagamentos();
    //                pagamentos.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
    //                for (Pagamento paux : pagamentos) {
    //                    Extrato extrato = new Extrato("pagamento", paux.getValor(), paux.getData());
    //                    extrato.setIdPagamento(paux.getId());
    //                    extratos.add(extrato);
    //                }
    //            }
    //        }
    //        Collections.reverse(extratos);
    //        mv.addObject("extratos", extratos);
    //        mv.addObject("cliente", c);
    //        return mv;
    //    }
}
