package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {

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

    @Test
    @DisplayName("Test de creación de retraso y verificación de empleado")
    void testCreacionRetraso() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Retraso retraso = new Retraso(empleado, Instant.now());

        assertEquals(empleado.getNombre(), retraso.getEmpleado().getNombre(), "El empleado debería ser el mismo que se pasó al constructor.");
        System.out.println("testCreacionRetraso: Prueba completada con éxito.");
        System.out.println("Empleado: " + retraso.getEmpleado().getNombre());
    }

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
