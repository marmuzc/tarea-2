package org.example;

import java.time.Instant;

/**
 * Clase que representa un retraso en la asistencia de un empleado a una reunión.
 * Hereda de la clase {@link Asistencia} e incluye la hora de llegada del empleado.
 */
public class Retraso extends Asistencia {
    private Instant horaLlegada;

    /**
     * Constructor que crea un objeto de tipo Retraso.
     * 
     * @param empleado El empleado que ha llegado tarde a la reunión.
     * @param horaLlegada La hora a la que llegó el empleado.
     */
    public Retraso(Empleado empleado, Instant horaLlegada) {
        super(empleado, horaLlegada);
        this.horaLlegada = Instant.now(); // Tomamos la hora actual como hora de llegada
    }

    /**
     * Obtiene la hora de llegada del empleado.
     * 
     * @return La hora de llegada del empleado.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Devuelve una representación en cadena de la clase {@code Retraso}.
     * 
     * @return Una cadena con la información del retraso, incluyendo el nombre del empleado y la hora de llegada.
     */
    @Override
    public String toString() {
        return "Retraso{" +
                "empleado=" + getEmpleado().getNombre() +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
