package br.com.bertolotoLucas.sistemaDeCobranca.controller.pagamento;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.PagamentoService;
import br.com.bertolotoLucas.sistemaDeCobranca.utils.LocalDateTimeUtil;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewPagamentoController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("/{idCliente}/newPagamento/")
    public ModelAndView getPagamentoForm(@PathVariable Long idCliente) {
        ModelAndView mv = new ModelAndView();
        Cliente c = clienteService.findById(idCliente);
        if (Objects.isNull(c)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        Pagamento p = new Pagamento();
        p.setCliente(c);
        mv.addObject("pagamento", p);
        mv.setViewName("newPagamentoForm");
        return mv;
    }

    @PostMapping("/savePagamento")
    public String savePagamento(@ModelAttribute Pagamento pagamento) {
        if (Objects.isNull(pagamento)) {
            return "redirect:/";
        }
        pagamento.setCliente(clienteService.findById(pagamento.getCliente().getId()));
        if (Objects.isNull(pagamento.getId())) {
            if (Objects.isNull(pagamento.getData())) pagamento.setData(
                LocalDateTimeUtil.retirarOsSegundos(LocalDateTime.now())
            );
        } else {
            //data is incoming without the seconds! resolving this..
            pagamento.setData(pagamentoService.findById(pagamento.getId()).getData());
        }
        pagamentoService.save(pagamento);
        clienteService.atualizaSaldo(pagamento.getCliente());
        return "redirect:/listExtrato/" + pagamento.getCliente().getId().toString();
    }
}
