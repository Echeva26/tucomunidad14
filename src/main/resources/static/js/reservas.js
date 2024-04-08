function cargarReservasPorDia() {
    // Obtener el valor del día seleccionado
    var diaSeleccionado = document.getElementById("input-dia").value;
  
    // Realizar una solicitud Ajax para obtener las reservas para el día seleccionado
    fetch("/reservas/porAreaComunYDia/{areaComunId}?fecha=" + diaSeleccionado)
      .then(response => response.json())
      .then(data => {
        // Actualizar la vista con las reservas obtenidas
        actualizarHorarioReservas(data);
      })
      .catch(error => console.error("Error al cargar las reservas:", error));
  }
  
  function actualizarHorarioReservas(reservas) {
    // Limpiar el horario de reservas
    var horarioReservas = document.querySelector(".horario-reservas");
    horarioReservas.innerHTML = "";
  
    // Generar los cuadrados de reservas por cada hora desde las 10:00:00 hasta las 22:00:00
    for (var hora = 10; hora <= 22; hora++) {
      var cuadrado = document.createElement("div");
      cuadrado.classList.add("cuadrado-reserva");
  
      // Verificar si hay una reserva para esta hora
      var reserva = reservas.find(reserva => {
        var inicioReserva = new Date(reserva.inicioReserva);
        return inicioReserva.getHours() === hora;
      });
  
      // Establecer el color del cuadrado dependiendo de si hay una reserva o no
      if (reserva) {
        cuadrado.classList.add("reservado");
      } else {
        cuadrado.classList.add("libre");
      }
  
      // Agregar el cuadrado al horario de reservas
      horarioReservas.appendChild(cuadrado);
    }
  }
  