package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import br.com.bertolotoLucas.sistemaDeCobranca.utils.Matcher;
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

    @Column
    private String celular;

    @Column
    private String endereco;

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

    public Cliente(String nome) {
        this.nome = nome;
        this.saldo = 0;
    }

    public Cliente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public Cliente(String nome, double saldo, String celular) {
        this.nome = nome;
        this.saldo = saldo;
        if (new Matcher().matchCelular(celular)) {
            this.celular = celular;
        } else {
            this.celular = "";
        }
    }

    public Cliente(String nome, double saldo, String celular, String endereco) {
        this.nome = nome;
        this.saldo = saldo;
        if (new Matcher().matchCelular(celular)) {
            this.celular = celular;
        } else {
            this.celular = "";
        }
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if (new Matcher().matchCelular(celular)) {
            this.celular = celular;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        return (
            "Cliente{" +
            "id=" +
            id +
            ", nome='" +
            nome +
            '\'' +
            ", saldo=" +
            saldo +
            ", celular='" +
            celular +
            '\'' +
            '}'
        );
    }
}
