package br.com.bertolotoLucas.sistemaDeCobranca.controller.pagamento;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.PagamentoService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdatePagamentoController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("{idCliente}/updatePagamento/{id}")
    public ModelAndView getPagamentoUpdateForm(@PathVariable Long idCliente, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = clienteService.findById(idCliente);
        if (Objects.isNull(cliente)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        Pagamento pagamento = null;
        List<Pagamento> pagamentos = cliente.getPagamentos();
        if (Objects.isNull(pagamentos)) {
            mv.setViewName("redirect:/listExtrato/" + cliente.getId());
            return mv;
        }
        for (Pagamento p : pagamentos) {
            if (p.getId().equals(id)) {
                pagamento = p;
            }
        }
        if (Objects.isNull(pagamento)) {
            mv.setViewName("redirect:/listExtrato/" + cliente.getId());
            return mv;
        }
        mv.addObject("pagamento", pagamento);
        mv.setViewName("updatePagamentoForm");
        return mv;
    }
}
