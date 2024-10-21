package org.example;

import java.time.Instant;

/**
 * Clase que representa un empleado que asiste a la reunión.
 * Contiene información sobre el empleado y su hora de llegada.
 */
public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;

    /**
     * Constructor que crea un objeto de tipo Asistencia.
     * 
     * @param empleado El empleado que asiste a la reunión.
     * @param horaLlegada La hora a la que llegó el empleado a la reunión.
     */
    public Asistencia(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    /**
     * Devuelve el empleado que ha asistido a la reunión.
     * 
     * @return El empleado que asiste a la reunión.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Devuelve la hora de llegada del empleado.
     * 
     * @return La hora de llegada del empleado.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Devuelve una representación en cadena de la clase {@code Asistencia}.
     * 
     * @return Una cadena con la información del empleado y la hora de llegada.
     */
    @Override
    public String toString() {
        return "Asistencia{" +
                "empleado=" + empleado.getNombre() +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
