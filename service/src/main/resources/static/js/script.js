var btnDels = document.querySelectorAll("#btnDel");
//btnUps.forEach((btnUp) => {console.log(btnUp.href)});

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