package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import br.com.bertolotoLucas.sistemaDeCobranca.utils.FormasPagamento;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column
    private FormasPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Deprecated
    public Pagamento() {}

    public Pagamento(double valor, LocalDateTime data, Cliente cliente) {
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormasPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", valor=" + valor + ", data=" + data + ", cliente=" + cliente + '}';
    }
}
