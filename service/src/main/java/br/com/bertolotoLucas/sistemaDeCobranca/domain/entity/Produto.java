package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

public class Produto {
    private long id;
    private long idCliente;
    private int quantidade;
    private String descricao;
    private double valorUnitario;

    @Deprecated
    public Produto() {}

    public Produto(int quantidade, String descricao, double valorUnitario) {
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }

    @Override
    public String toString() {
        return (
            "Produto{" +
            "id=" +
            id +
            ", idCliente=" +
            idCliente +
            ", quantidade=" +
            quantidade +
            ", descricao='" +
            descricao +
            '\'' +
            ", valorUnitario=" +
            valorUnitario +
            '}'
        );
    }
}
