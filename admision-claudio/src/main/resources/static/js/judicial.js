function toggleArchivos(opcion) {
    var archivosContainer = document.getElementById('archivosContainer');
    var guardarCambiosBtn = document.getElementById("guardarCambiosBtnModal"); // Cambiado el ID

    if (opcion === "condenado") {
        archivosContainer.style.display = "block";
        if (guardarCambiosBtn) {
            guardarCambiosBtn.removeAttribute("disabled");
        }
    } else {
        archivosContainer.style.display = "none";
        if (guardarCambiosBtn) {
            guardarCambiosBtn.setAttribute("disabled", "true");
        }
    }
}

document.getElementById('situacionLegal').addEventListener('change', function() {
    var isProcesado = this.value === 'procesado';
    
    var archivosContainer = document.getElementById('archivosContainer');
    var guardarCambiosBtn = document.getElementById('guardarCambiosBtnModal');

    // Aquí configuramos los campos como requeridos o no requeridos
    document.getElementById('cama').required = !isProcesado;
    document.getElementById('fechaC').required = !isProcesado;
    document.getElementById('cimp').required = !isProcesado;
    document.getElementById('sen').required = !isProcesado;
    document.getElementById('reduc').required = !isProcesado;
    document.getElementById('lib').required = !isProcesado;
    document.getElementById('libcon').required = !isProcesado;
    document.getElementById('asis').required = !isProcesado;
    document.getElementById('susp').required = !isProcesado;
    
    

    if (isProcesado) {
        archivosContainer.style.display = 'none';
        if (guardarCambiosBtn) {
            guardarCambiosBtn.setAttribute('disabled', 'true');
        }
    } else {
        archivosContainer.style.display = 'block';
        if (guardarCambiosBtn) {
            guardarCambiosBtn.removeAttribute('disabled');
        }
    }
});
