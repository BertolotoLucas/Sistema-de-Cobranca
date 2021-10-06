var cel = document.getElementById("celular");
cel.addEventListener("click", function() {
    if (cel.value == "") {
        cel.value = "(21) ";
    }
});