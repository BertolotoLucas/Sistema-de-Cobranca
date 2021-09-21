package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPagamento", nullable = false)
    private long id;

    @Column(name = "valor", nullable = false)
    private float valor;

    @Column(name = "data", nullable = false)
    private String data;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente", nullable = false)
    private Cliente cliente;

    private Pagamento(long id, float valor, String data, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return (
            id == pagamento.id &&
            Float.compare(pagamento.valor, valor) == 0 &&
            Objects.equals(data, pagamento.data) &&
            Objects.equals(cliente, pagamento.cliente)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, data, cliente);
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", valor=" + valor + ", data='" + data + '\'' + ", cliente=" + cliente + '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private long id;
        private float valor;
        private String data;
        private Cliente cliente;

        private Builder() {}

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder valor(float valor) {
            this.valor = valor;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Pagamento build() {
            Pagamento pagamento = new Pagamento(id, valor, data, cliente);
            return pagamento;
        }
    }
}
