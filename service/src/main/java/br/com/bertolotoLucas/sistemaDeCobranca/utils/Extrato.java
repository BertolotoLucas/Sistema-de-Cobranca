package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Pagamento;

import java.util.List;

public class Extrato {
    private Compra compra;
    private Pagamento pagamento;


    public Extrato(Compra compra, Pagamento pagamento) {
        this.compra = compra;
        this.pagamento = pagamento;
    }

    public Extrato() {}

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Extrato{" +
                "compras=" + compra +
                ", pagamentos=" + pagamento +
                '}';
    }
}
