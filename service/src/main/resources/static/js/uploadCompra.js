document.addEventListener('DOMContentLoaded', (e) => {
    var descricao = document.getElementById("descricao").value;
    const form = document.getElementById("form");
    var lastElement = form;

    var produtos = descricao.split(";");
    for (i = 0; i < produtos.length - 1; i++){
        var qtdProduto = produtos[i].split("/")[0];
        var descProduto = produtos[i].split("/")[1];
        var valProduto = produtos[i].split("/")[2];
        var html = '<div class="produto">' +
        '<p>Produto ' + (i + 1) + '</p>' +
        '<hr>' +
        '<div class="form-group">' +
        '<p style="margin: 5px 0;">Quantidade:</p>' +
        '<input type="number" class="form-control qtdProduto" onClick="this.select();" min="1" max="99" placeholder="3" value="' + qtdProduto + '" required>' +
        '</div>' +
        '<div class="form-group">' +
        '<p style="margin: 5px 0;">Descrição:</p>' +
        '<input type="text" class="form-control descProduto" placeholder="Blusa Nike azul" value="' + descProduto + '" required>' +
        '</div>' +
        '<div class="form-group">' +
        '<p style="margin: 5px 0;">Valor Unitário:</p>' +
        '<input type="number"  class="form-control valProduto" onClick="this.select();" min="1.00" step="0.01" value="' + valProduto + '" required>' +
        '</div>' +
        '<button id="btnDelProduto" style="padding: 0; margin: 0; border-width:0; background-color: #FFFFFF;" type="button" title="Adicionar Um Novo Produto">' +
        '<span class="btn btn-danger btn-sm rounded-pill editLink material-icons" style="padding:0.4em;">remove</span>' +
        '</button>' +
        '<hr>' +
        '</div>';
        var parser = new DOMParser();
        var htmlElement = parser.parseFromString(html, 'text/html');
        lastElement.insertAdjacentElement('afterend', htmlElement.body);
        var produtosClass = document.querySelectorAll(".produto");
        var qtdProdutos = produtosClass.length;
        var lastElement = produtosClass[qtdProdutos - 1];
    }
    addEventListenerBtnDelProduto();
    function addEventListenerBtnDelProduto() {
        var btnDelProdutos = document.querySelectorAll("#btnDelProduto");
        for (var i = 0; i < btnDelProdutos.length; i++) {
            var btnDelProduto = btnDelProdutos[i];
            btnDelProduto.addEventListener('click', function (event) {
                event.preventDefault();
                this.parentNode.parentNode.removeChild(this.parentNode);
            });
        }
    }
});