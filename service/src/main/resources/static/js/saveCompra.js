var valorTotal = document.getElementById("valor");
var descricao = document.getElementById("descricao");
var btnSaveCompra = document.getElementById("btnSaveCompra");
btnSaveCompra.addEventListener("click", function(){
    var qtdProdutos = document.querySelectorAll(".qtdProduto");
    var descProdutos = document.querySelectorAll(".descProduto");
    var valProdutos = document.querySelectorAll(".valProduto");
    valorTotal.value = "";
    descricao.value = "";
    var vlrTot = 0;
    for (i = 0; i < qtdProdutos.length; i++){
        var qtdProduto = qtdProdutos[i].value;
        var descProduto = descProdutos[i].value;
        var valProduto = valProdutos[i].value;
        vlrTot += Number(valProduto) * Number(qtdProduto);
        descricao.value += qtdProduto+'/'+descProduto+'/'+valProduto+';';
    }
    valorTotal.value = vlrTot.toFixed(2);
    document.getElementById("form").submit();
});