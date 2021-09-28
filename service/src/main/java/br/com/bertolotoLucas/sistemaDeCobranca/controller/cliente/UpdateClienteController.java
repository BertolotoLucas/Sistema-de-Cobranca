package br.com.bertolotoLucas.sistemaDeCobranca.controller.cliente;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpdateClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/updateCliente/{id}")
    public ModelAndView updateClienteForm(@PathVariable Long id) {
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("clienteFormUpdate").addObject("cliente", c);
    }

    @RequestMapping(value = "/updateCliente/{id}", method = RequestMethod.POST)
    public String updateCliente(
        @PathVariable Long id,
        @Valid Cliente cliente,
        BindingResult result,
        RedirectAttributes attributes
    ) {
        Cliente c = clienteService.findById(id);
        c.setNome(cliente.getNome());
        clienteService.save(c);
        return "redirect:/";
    }
    //
    //    @GetMapping(value = "/updateClientePagamento/{id}")
    //    public String updateClientePagamento(@PathVariable Long id) {
    //        Cliente c = clienteService.findById(id);
    //        if (Objects.isNull(c)) {
    //            return "redirect:/";
    //        }
    //        c.setSaldo(c.getSaldo() + 10);
    //        clienteService.save(c);
    //        return "redirect:/";
    //    }
    //
    //    @GetMapping(value = "/updateClienteCompra/{id}")
    //    public String updateClienteCompra(@PathVariable Long id) {
    //        Cliente c = clienteService.findById(id);
    //        if (Objects.isNull(c)) {
    //            return "redirect:/";
    //        }
    //        c.setSaldo(c.getSaldo() - 10);
    //        clienteService.save(c);
    //        return "redirect:/";
    //    }
}
