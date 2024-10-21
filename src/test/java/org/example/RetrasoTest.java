package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Retraso.
 * Contiene pruebas unitarias para los métodos de la clase Retraso.
 */
class RetrasoTest {

    /**
     * Prueba que verifica la obtención de la hora de llegada.
     * Se asegura de que la hora de llegada no sea nula.
     */
    @Test
    @DisplayName("Test de obtener hora de llegada")
    void getHoraLlegada() {
        Instant horaLlegadaEsperada = Instant.now();
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Retraso retraso = new Retraso(empleado, horaLlegadaEsperada);

        assertNotNull(retraso.getHoraLlegada(), "La hora de llegada no debería ser nula.");
        System.out.println("getHoraLlegada: Prueba completada con éxito.");
        System.out.println("Hora de llegada: " + retraso.getHoraLlegada());
    }

    /**
     * Prueba que verifica la creación de un retraso y la verificación del empleado.
     * Se asegura de que el empleado sea el mismo que se pasó al constructor.
     */
    @Test
    @DisplayName("Test de creación de retraso y verificación de empleado")
    void testCreacionRetraso() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Retraso retraso = new Retraso(empleado, Instant.now());

        assertEquals(empleado.getNombre(), retraso.getEmpleado().getNombre(), "El empleado debería ser el mismo que se pasó al constructor.");
        System.out.println("testCreacionRetraso: Prueba completada con éxito.");
        System.out.println("Empleado: " + retraso.getEmpleado().getNombre());
    }

    /**
     * Prueba que verifica el método toString de la clase Retraso.
     * Se asegura de que el método toString devuelva el formato esperado.
     */
    @Test
    @DisplayName("Test de toString del retraso")
    void testToString() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Retraso retraso = new Retraso(empleado, Instant.now());

        String expectedString = "Retraso{empleado=Tobias, horaLlegada=" + retraso.getHoraLlegada() + '}';
        assertEquals(expectedString, retraso.toString(), "toString de la clase Retraso debería ser correcta.");
        System.out.println("testToString: Prueba completada con éxito.");
        System.out.println("toString del retraso: " + retraso.toString());
    }
}