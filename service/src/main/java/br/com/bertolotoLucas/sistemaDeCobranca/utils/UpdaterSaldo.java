package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Cliente;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;
import br.com.bertolotoLucas.sistemaDeCobranca.service.ClienteService;
import java.util.List;
import java.util.Objects;

public class UpdaterSaldo {

    public Cliente atualizaSaldo(Cliente cliente) {
        double saldo = 0;

        List<Compra> compras = cliente.getCompras();
        if (!Objects.isNull(compras)) {
            for (Compra c : compras) {
                saldo = saldo - c.getValor();
            }
        }
        List<Pagamento> pagamentos = cliente.getPagamentos();
        if (!Objects.isNull(compras)) {
            for (Pagamento p : pagamentos) {
                saldo = saldo + p.getValor();
            }
        }
        cliente.setSaldo(saldo);
        return cliente;
    }
}
