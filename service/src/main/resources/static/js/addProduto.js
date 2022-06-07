var btnAddProduto = document.getElementById("btnAddProduto");
btnAddProduto.addEventListener("click", function(){
    var produtos = document.querySelectorAll(".produto");
    var qtdProdutos = produtos.length;
    var lastElement = produtos[qtdProdutos - 1];
    var html = '<div class="produto">' +
               '<p>Produto ' + (qtdProdutos + 1) + '</p>' +
               '<hr>' +
               '<div class="form-group">' +
               '<p style="margin: 5px 0;">Quantidade:</p>' +
               '<input type="number" class="form-control qtdProduto" onClick="this.select();" min="1" max="99" placeholder="3" required>' +
               '</div>' +
               '<div class="form-group">' +
               '<p style="margin: 5px 0;">Descrição:</p>' +
               '<input type="text" class="form-control descProduto" placeholder="Blusa Nike azul" required>' +
               '</div>' +
               '<div class="form-group">' +
               '<p style="margin: 5px 0;">Valor Unitário:</p>' +
               '<input type="number"  class="form-control valProduto" onClick="this.select();" min="1.00" step="0.01"  required>' +
               '</div>' +
               '<button id="btnDelProduto" style="padding: 0; margin: 0; border-width:0; background-color: #FFFFFF;" type="button" title="Adicionar Um Novo Produto">' +
               '<span class="btn btn-danger btn-sm rounded-pill editLink material-icons" style="padding:0.4em;">remove</span>' +
               '</button>' +
               '<hr>' +
               '</div>';
    var parser = new DOMParser();
    var htmlElement = parser.parseFromString(html, 'text/html');
    lastElement.insertAdjacentElement('afterend', htmlElement.body);
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