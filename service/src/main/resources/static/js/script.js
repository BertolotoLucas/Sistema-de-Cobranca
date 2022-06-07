var btnDels = document.querySelectorAll("#btnDel");

function deleteCliente(idCliente) {
      fetch("/deleteCliente/"+idCliente, {
         method:"DELETE",
      })
}

function updateCliente(cliente) {
      fetch("/updateCliente/", {
         method:"PUT",
         body: cliente,
      })
}