package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

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
