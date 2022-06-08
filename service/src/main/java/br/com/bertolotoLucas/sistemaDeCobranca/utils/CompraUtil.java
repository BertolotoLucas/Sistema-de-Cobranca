package br.com.bertolotoLucas.sistemaDeCobranca.utils;

import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Compra;
import br.com.bertolotoLucas.sistemaDeCobranca.domain.entity.Produto;
import java.util.ArrayList;
import java.util.List;

public class CompraUtil {

    public static void produtosToCompra(List<Produto> produtos, Compra compra) {
        double valorTotalCompra = 0;
        StringBuilder descricao = new StringBuilder();
        for (Produto p : produtos) {
            descricao.append(p.getQuantidade()).append("/");
            descricao.append(p.getDescricao()).append("/");
            descricao.append(p.getValorUnitario()).append(";");
            valorTotalCompra += p.getValorTotal();
        }
        compra.setDescricao(descricao.toString());
        compra.setValor(valorTotalCompra);
    }

    public static List<Produto> compraToProdutos(Compra compra) {
        String descricaoCompleta = compra.getDescricao();
        String[] produtosString = descricaoCompleta.split(";");
        List<Produto> produtos = new ArrayList<Produto>();
        for (String produtoString : produtosString) {
            String[] atributosProduto = produtoString.split("/");
            String quantidade = atributosProduto[0];
            String descricao = atributosProduto[1];
            String valorUnitario = atributosProduto[2];
            Produto produto = new Produto(Integer.parseInt(quantidade), descricao, Double.parseDouble(valorUnitario));
            produtos.add(produto);
        }
        return produtos;
    }

    public static double valorTotal(Compra compra) {
        return valorTotal(compraToProdutos(compra));
    }

    public static double valorTotal(List<Produto> produtos) {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getValorTotal();
        }
        return total;
    }
}
