package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double saldo;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @OneToMany(mappedBy = "cliente")
    private List<Pagamento> pagamentos;

    @PreRemove
    public void atualizaRelacionamentosOnRemove() {
        atualizaComprasOnRemove();
        atualizaPagamentosOnRemove();
    }

    private void atualizaComprasOnRemove() {
        if (!Objects.isNull(this.getCompras())) for (Compra c : this.getCompras()) {
            c.setCliente(null);
        }
    }

    private void atualizaPagamentosOnRemove() {
        if (!Objects.isNull(this.getPagamentos())) for (Pagamento p : this.getPagamentos()) {
            p.setCliente(null);
        }
    }

    @Deprecated
    public Cliente() {}

    public Cliente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        if (this.saldo == 0) {
            double result = 0;
            if (!Objects.isNull(this.compras)) for (Compra c : this.compras) {
                result = result - c.getValor();
            }
            if (!Objects.isNull(this.pagamentos)) for (Pagamento p : this.pagamentos) {
                result = result + p.getValor();
            }
        }
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome='" + nome + '\'' + ", saldo=" + saldo + '}';
    }
}
