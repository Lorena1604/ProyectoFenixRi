
 function editarCorreo() {
        var validar = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        var x = prompt('Ingrese nuevo correo electrónico:'); 
       if (x=='') {
       alert("Error ingrese un correo electrónico");
       };
       if (!validar.test(x)) {
        alert("Correo electrónico invalido");
       }else{
        document.getElementById("Correo").innerHTML = x;
       }    
    }

 function editarTelefono() {
     var validarTel = /^\d{7}$/;
     var numero= /^([0-9]+){9}$/;
     var telefono = prompt('Ingrese nuevo teléfono');

     if (telefono=='') {
      alert("Error ingrese un teléfono");
     }
     if (telefono<10) {
      alert("minimo 7 numeros");
     }
    else if(!(/^\d{10}$/.test(telefono))) {
      alert("minimo 7 numeros");
      
     }else{
      document.getElementById("Telefono").innerHTML = telefono;
     }
}
 


