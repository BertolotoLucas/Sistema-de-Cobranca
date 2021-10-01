package br.com.bertolotoLucas.sistemaDeCobranca.controller.cliente;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.service.ClienteService;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpdateClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/updateCliente/{id}")
    public String updateClienteForm(@PathVariable(value = "id") Long id, Model model) {
        Cliente c = clienteService.findById(id);
        if (Objects.isNull(c)) {
            return "/";
        }
        model.addAttribute("cliente", c);
        return "clienteFormUpdate";
    }
    //
    //    @RequestMapping(value = "/updateCliente/", method = RequestMethod.PUT)
    //    @ResponseBody
    //    public String updateCliente(@RequestBody Cliente cliente) {
    //        Cliente c = clienteService.findById(cliente.getId());
    //        c.setNome(cliente.getNome());
    //        clienteService.save(c);
    //        return "redirect:/";
    //    }
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
