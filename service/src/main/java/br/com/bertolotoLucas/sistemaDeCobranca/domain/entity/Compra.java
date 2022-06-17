package br.com.bertolotoLucas.sistemaDeCobranca.domain.entity;

import br.com.bertolotoLucas.sistemaDeCobranca.utils.LocalDateTimeUtil;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Deprecated
    public Compra() {}

    public Compra(double valor, LocalDateTime data, String descricao, Cliente cliente) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Compra(double valor, String descricao, Cliente cliente) {
        this.valor = valor;
        this.data = LocalDateTimeUtil.retirarOsSegundos(LocalDateTime.now());
        this.descricao = descricao;
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

    public String getDataformatada() {
        return data == null ? "" : new SimpleDateFormat("dd-MM-yyyy'T'HH:mm").format(data);
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return (
            "Compra{" +
            "id=" +
            id +
            ", valor=" +
            valor +
            ", data=" +
            data +
            ", descricao='" +
            descricao +
            '\'' +
            ", cliente=" +
            cliente +
            '}'
        );
    }
}
