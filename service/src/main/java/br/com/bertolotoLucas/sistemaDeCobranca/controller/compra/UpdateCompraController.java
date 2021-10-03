package br.com.bertolotoLucas.sistemaDeCobranca.controller.compra;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.CompraService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateCompraController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/{idCliente}/updateCompra/{id}")
    public ModelAndView getCompraForm(@PathVariable Long idCliente, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = clienteService.findById(idCliente);
        if (Objects.isNull(cliente)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        Compra compra = null;
        List<Compra> compras = cliente.getCompras();
        if (Objects.isNull(compras)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        for (Compra c : compras) {
            if (c.getId().equals(id)) {
                compra = c;
            }
        }
        if (Objects.isNull(compra)) {
            mv.setViewName("redirect:/");
            return mv;
        }
        System.out.println("Compra indo para o formulario para atualizar : " + compra);
        mv.addObject("compra", compra);
        mv.setViewName("updateCompraForm");
        return mv;
    }
}
