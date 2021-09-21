package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "idCliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private long nome;

    @Column(name = "valorPendente", nullable = false)
    private float valorPendente;

    private Cliente(long id, long nome, float valorPendente) {
        this.id = id;
        this.nome = nome;
        this.valorPendente = valorPendente;
    }

    public void pagar(Pagamento p) {
        valorPendente -= p.getValor();
    }

    public void comprar(Compra c) {
        valorPendente += c.getValor();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNome() {
        return nome;
    }

    public void setNome(long nome) {
        this.nome = nome;
    }

    public float getValorPendente() {
        return valorPendente;
    }

    public void setValorPendente(float valorPendente) {
        this.valorPendente = valorPendente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && nome == cliente.nome && Float.compare(cliente.valorPendente, valorPendente) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valorPendente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", valorPendente=" + valorPendente + '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private long id;
        private long nome;
        private float valorPendente;

        private Builder() {}

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder nome(long nome) {
            this.nome = nome;
            return this;
        }

        public Builder valorPendente(float valorPendente) {
            this.valorPendente = valorPendente;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente(id, nome, valorPendente);
            return cliente;
        }
    }
}
