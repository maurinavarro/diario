document.addEventListener("DOMContentLoaded", function () {
    const searchBar = document.getElementById("search-bar");
    const searchInput = searchBar.querySelector("input");
    const tableRows = document.querySelectorAll("#tablaHome tbody tr");
    const filasPorPagina = 3;
    let paginaActual = 1;

    searchInput.addEventListener("input", function () {
        const searchTerm = this.value.trim().toLowerCase();
        mostrarFilasConFiltro(searchTerm);
    });

    function mostrarFilasConFiltro(searchTerm) {
        tableRows.forEach(function (row) {
            const detenidoName = row.cells[2].innerText.toLowerCase();
            const detenidoDni = row.cells[3].innerText.toLowerCase();
            const usuarioUnidadSolicitante = row.cells[5].innerText.toLowerCase();
            const showRow = searchTerm.length >= 3 && (detenidoName.includes(searchTerm) || detenidoDni.includes(searchTerm) || usuarioUnidadSolicitante.includes(searchTerm));
            row.style.display = showRow ? "" : "none";
        });

        if (searchTerm === "") {
            irAPagina(paginaActual); // Restablece la paginación después de borrar el término de búsqueda
        }
    }

    function irAPagina(pagina) {
        if (pagina < 1) {
            pagina = 1;
        } else if (pagina > totalPaginas) {
            pagina = totalPaginas;
        }
        paginaActual = pagina;
        mostrarFilasPaginadas(pagina);
    }

    function mostrarFilasPaginadas(pagina) {
        const inicio = (pagina - 1) * filasPorPagina;
        const fin = inicio + filasPorPagina;
        tableRows.forEach(function (row, index) {
            if (index >= inicio && index < fin) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });
        document.getElementById('paginaActual').textContent = pagina;
    }

    // Resto de tu código para la paginación
    const tabla = document.getElementById('tablaHome');
    const totalFilas = tabla.getElementsByTagName('tbody')[0].getElementsByTagName('tr').length;
    const totalPaginas = Math.ceil(totalFilas / filasPorPagina);

    mostrarFilasPaginadas(paginaActual);

    document.getElementById('anterior').addEventListener('click', function () {
        irAPagina(paginaActual - 1);
    });

    document.getElementById('siguiente').addEventListener('click', function () {
        irAPagina(paginaActual + 1);
    });
});

document.getElementById('siguiente').addEventListener('click', function () {
    irAPagina(paginaActual + 1);
});

const filasPorPagina1 = 3; // Define el número de filas por página
let paginaActual1 = 1;
const tabla1 = document.getElementById('tablaHome1');
const totalFilas1 = tabla1.getElementsByTagName('tbody')[0].getElementsByTagName('tr').length;
const totalPaginas1 = Math.ceil(totalFilas1 / filasPorPagina1);

function mostrarFilas1(pagina) {
    const filas = tabla1.getElementsByTagName('tbody')[0].getElementsByTagName('tr');
    for (let i = 0; i < filas.length; i++) {
        filas[i].style.display = 'none';
    }
    const inicio = (pagina - 1) * filasPorPagina1;
    const fin = inicio + filasPorPagina1;
    for (let i = inicio; i < fin && i < filas.length; i++) {
        filas[i].style.display = '';
    }
    document.getElementById('paginaActual1').textContent = pagina;
}

function irAPagina1(pagina) {
    if (pagina < 1) {
        pagina = 1;
    } else if (pagina > totalPaginas1) {
        pagina = totalPaginas1;
    }
    paginaActual1 = pagina;
    mostrarFilas1(pagina);
}

mostrarFilas1(paginaActual1);

document.getElementById('anterior1').addEventListener('click', function () {
    irAPagina1(paginaActual1 - 1);
});

document.getElementById('siguiente1').addEventListener('click', function () {
    irAPagina1(paginaActual1 + 1);
});

