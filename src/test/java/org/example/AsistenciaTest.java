package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {

    @Test
    @DisplayName("Test de asistencia con todo correcto")
    void testAsistenciaInicializacionCorrecta() {
        Empleado empleado = new Empleado("1", "Perez del Campo", "Tobias", "toperez@gmail.com");
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(empleado, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado(), "El empleado debería ser el mismo que se estableció en la asistencia");
        assertEquals(horaLlegada, asistencia.getHoraLlegada(), "La hora de llegada debería ser la misma que se estableció en la asistencia");

        System.out.println("testAsistenciaInicializacionCorrecta: Empleado - " + asistencia.getEmpleado());
        System.out.println("testAsistenciaInicializacionCorrecta: Hora de llegada - " + asistencia.getHoraLlegada());
    }

    @Test
    @DisplayName("Test de asistencia sin empleado/empleado nulo")
    void testAsistenciaConEmpleadoNulo() {
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(null, horaLlegada);

        assertNull(asistencia.getEmpleado(), "El empleado debería ser null si se pasó null en el constructor");

        if (asistencia.getEmpleado() == null) {
            System.out.println("testAsistenciaConEmpleadoNulo: El empleado es null.");
        }

        System.out.println("testAsistenciaConEmpleadoNulo: Hora de llegada - " + asistencia.getHoraLlegada());
    }

    @Test
    @DisplayName("Test de asistencia sin hora de llegada/hora de llegada nula")
    void testAsistenciaConHoraLlegadaNula() {
        Empleado empleado = new Empleado("1", "Perez del Campo", "Tobias", "toperez@gmail.com");

        Asistencia asistencia = new Asistencia(empleado, null);

        assertNull(asistencia.getHoraLlegada(), "La hora de llegada debería ser null si se pasó null en el constructor");

        if (asistencia.getHoraLlegada() == null) {
            System.out.println("testAsistenciaConHoraLlegadaNula: La hora de llegada es null.");
        }

        System.out.println("testAsistenciaConHoraLlegadaNula: Empleado - " + asistencia.getEmpleado());
    }

    @Test
    @DisplayName("Test de asistencia para más de un empleado")
    void testAsistenciaDiferentesEmpleados() {
        Empleado empleado1 = new Empleado("1", "Perez del Campo", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch L", "Ross", "rosslynch@gmail.com");
        Instant horaLlegada1 = Instant.now();
        Instant horaLlegada2 = Instant.now().plusSeconds(3600); // 1 hora después

        Asistencia asistencia1 = new Asistencia(empleado1, horaLlegada1);
        Asistencia asistencia2 = new Asistencia(empleado2, horaLlegada2);

        assertNotEquals(asistencia1, asistencia2, "Las asistencias no deberían ser iguales");

        System.out.println("testAsistenciaDiferentesEmpleados: Asistencia 1 - Empleado: " + asistencia1.getEmpleado() + ", Hora de llegada: " + asistencia1.getHoraLlegada());
        System.out.println("testAsistenciaDiferentesEmpleados: Asistencia 2 - Empleado: " + asistencia2.getEmpleado() + ", Hora de llegada: " + asistencia2.getHoraLlegada());
    }
}
