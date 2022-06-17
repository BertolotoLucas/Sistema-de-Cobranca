package br.com.bertolotoLucas.sistemaDeCobranca.controller.compra;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.CompraService;
import br.com.bertolotoLucas.sistemaDeCobranca.utils.LocalDateTimeUtil;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewCompraController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CompraService compraService;

    @GetMapping("/{idCliente}/newCompra")
    public ModelAndView getCompraForm(@PathVariable Long idCliente) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = clienteService.findById(idCliente);
        if (Objects.isNull(cliente)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        Compra compra = new Compra();
        compra.setCliente(cliente);
        mv.addObject("compra", compra);
        mv.setViewName("newCompraForm");
        return mv;
    }

    @PostMapping("/saveCompra")
    public String saveCompra(@ModelAttribute Compra compra) {
        if (Objects.isNull(compra)) {
            return "redirect:/";
        }
        compra.setCliente(clienteService.findById(compra.getCliente().getId()));
        if (Objects.isNull(compra.getId())) {
            if (Objects.isNull(compra.getData())) compra.setData(
                LocalDateTimeUtil.retirarOsSegundos(LocalDateTime.now())
            );
        } else {
            //data is incoming without the seconds! resolving this..
            compra.setData(compraService.findById(compra.getId()).getData());
        }
        compraService.save(compra);
        clienteService.atualizaSaldo(compra.getCliente());
        return "redirect:/listExtrato/" + compra.getCliente().getId().toString();
    }
}
