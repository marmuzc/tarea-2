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

        // Mensaje de éxito
        System.out.println("testAsistenciaInicializacionCorrecta: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de asistencia sin empleado/empleado nulo")
    void testAsistenciaConEmpleadoNulo() {
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(null, horaLlegada);

        assertNull(asistencia.getEmpleado(), "El empleado debería ser null si se pasó null en el constructor");

        // Mensaje de éxito
        System.out.println("testAsistenciaConEmpleadoNulo: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de asistencia sin hora de llegada/hora de llegada nula")
    void testAsistenciaConHoraLlegadaNula() {
        Empleado empleado = new Empleado("1", "Perez del Campo", "Tobias", "toperez@gmail.com");

        Asistencia asistencia = new Asistencia(empleado, null);

        assertNull(asistencia.getHoraLlegada(), "La hora de llegada debería ser null si se pasó null en el constructor");

        // Mensaje de éxito
        System.out.println("testAsistenciaConHoraLlegadaNula: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de asistencia para mas de un empleado")
    void testAsistenciaDiferentesEmpleados() {
        Empleado empleado1 = new Empleado("1", "Perez del Campo", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch L", "Ross", "rosslynch@gmail.com");
        Instant horaLlegada1 = Instant.now();
        Instant horaLlegada2 = Instant.now().plusSeconds(3600); // 1 hora después

        Asistencia asistencia1 = new Asistencia(empleado1, horaLlegada1);
        Asistencia asistencia2 = new Asistencia(empleado2, horaLlegada2);

        assertNotEquals(asistencia1, asistencia2, "Las asistencias no deberían ser iguales");

        // Mensaje de éxito
        System.out.println("testAsistenciaDiferentesEmpleados: Prueba completada con éxito.");
    }
}
