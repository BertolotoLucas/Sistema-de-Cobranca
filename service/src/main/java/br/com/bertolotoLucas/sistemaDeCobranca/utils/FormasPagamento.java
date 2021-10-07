package br.com.bertolotoLucas.sistemaDeCobranca.utils;

public enum FormasPagamento {
    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Crédito"),
    CARTAO_DEBITO("Débito"),
    PIX("Pix");

    private String formaPagamento;

    FormasPagamento(String forma) {
        this.formaPagamento = forma;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
