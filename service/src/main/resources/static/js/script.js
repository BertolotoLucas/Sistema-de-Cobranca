var btnDels = document.querySelectorAll("#btnDel");
//btnUps.forEach((btnUp) => {console.log(btnUp.href)});

function deleteCliente(idCliente) {
      fetch("/deleteCliente/"+idCliente, {
         method:"DELETE",
      })
}

function deleteCliente(idCliente) {
      fetch("/deleteCliente/"+idCliente, {
         method:"DELETE",
      })
}

//btnUps.forEach((btnUp) => {
//   btnUp.addEventListener("click", function() {
//      fetch(btnUp.name)
//      .then(function(response) {
//         console.log(response);
//         return response.json()
//      })
//      .then(function(response){
//         console.log(response);
//      })
//   })
//});