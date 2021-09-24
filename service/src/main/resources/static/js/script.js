var btnDels = document.querySelectorAll("#delClienteBtn");
var clientes = document.querySelectorAll("#cliente");
for (var i=0;i<btnDels.length;i++){
    var btnDel = btnDels[i];
    var cliente = clientes[i];
    var idCliente = cliente.querySelector("#idCliente");
    var id = idCliente.textContent;
    btnDel.addEventListener("click", function(event){
        cliente.remove();
    });
}
