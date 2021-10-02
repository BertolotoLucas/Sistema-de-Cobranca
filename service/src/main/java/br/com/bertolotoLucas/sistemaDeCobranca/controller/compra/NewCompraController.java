package br.com.bertolotoLucas.sistemaDeCobranca.controller.compra;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import br.com.bertolotoLucas.sistemaDeCobranca.service.CompraService;
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
        System.out.println("Compra indo para o formulario: " + compra);
        mv.addObject("compra", compra);
        mv.setViewName("newCompraForm");
        return mv;
    }

    @PostMapping("/saveCompra")
    public String saveCompra(@ModelAttribute Compra compra) {
        System.out.println("Recebi essa compra para salvar: " + compra);
        if (Objects.isNull(compra)) {
            return "redirect:/";
        }
        if (Objects.isNull(compra.getId())) {
            compra.setData(LocalDateTime.now());
        } else {
            //data is incoming without the seconds! resolving this..
            compra.setData(compraService.findById(compra.getId()).getData());
        }
        System.out.println("Modifiquei a data para salvar: " + compra);
        compraService.save(compra);
        Cliente clienteUp = compra.getCliente();
        //preciso implementar uma solução para modificar o cliente quando modificar a compra!
        //clienteUp.setSaldo(clienteUp.getSaldo()- compra.getValor());
        //clienteService.save(clienteUp);
        return "redirect:/listExtrato/" + compra.getCliente().getId().toString();
    }
}
