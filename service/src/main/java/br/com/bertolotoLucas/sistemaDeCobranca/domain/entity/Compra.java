package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
//@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idCompra", nullable = false)
    private long id;

    //@Column(name = "valor", nullable = false)
    private float valor;

    //@Column(name = "data", nullable = false)
    private String data;

    //@Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private Compra(long id, float valor, String data, String descricao, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return (
            id == compra.id &&
            Float.compare(compra.valor, valor) == 0 &&
            Objects.equals(data, compra.data) &&
            Objects.equals(descricao, compra.descricao) &&
            Objects.equals(cliente, compra.cliente)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, data, descricao, cliente);
    }

    @Override
    public String toString() {
        return (
            "Compra{" +
            "id=" +
            id +
            ", valor=" +
            valor +
            ", data='" +
            data +
            '\'' +
            ", descricao='" +
            descricao +
            '\'' +
            ", cliente=" +
            cliente +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private long id;
        private float valor;
        private String data;
        private String descricao;
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

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder cliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Compra build() {
            return new Compra(id, valor, data, descricao, cliente);
        }
    }
}
