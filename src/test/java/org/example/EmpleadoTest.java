package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Empleado.
 * Contiene pruebas unitarias para los métodos getter y setter de la clase Empleado.
 */
class EmpleadoTest {

    /**
     * Prueba que verifica el getter y setter para el ID del empleado.
     * Se asegura de que el ID se establezca y recupere correctamente.
     */
    @Test
    @DisplayName("Test de obtener y establecer ID del empleado")
    void getSetId() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        assertEquals("1", empleado.getId(), "El ID debería ser '1'");
        System.out.println("getSetId: El ID inicial es " + empleado.getId());

        empleado.setId("2");
        assertEquals("2", empleado.getId(), "El ID debería haber cambiado a '2'");
        System.out.println("getSetId: El ID actualizado es " + empleado.getId());
    }

    /**
     * Prueba que verifica el getter y setter para los apellidos del empleado.
     * Se asegura de que los apellidos se establezcan y recuperen correctamente.
     */
    @Test
    @DisplayName("Test de obtener y establecer apellidos del empleado")
    void getSetApellidos() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        assertEquals("Perez", empleado.getApellidos(), "Los apellidos deberían ser 'Perez'");
        System.out.println("getSetApellidos: Los apellidos iniciales son " + empleado.getApellidos());

        empleado.setApellidos("Lynch");
        assertEquals("Lynch", empleado.getApellidos(), "Los apellidos deberían haber cambiado a 'Lynch'");
        System.out.println("getSetApellidos: Los apellidos actualizados son " + empleado.getApellidos());
    }

    /**
     * Prueba que verifica el getter y setter para el nombre del empleado.
     * Se asegura de que el nombre se establezca y recupere correctamente.
     */
    @Test
    @DisplayName("Test de obtener y establecer nombre del empleado")
    void getSetNombre() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        assertEquals("Tobias", empleado.getNombre(), "El nombre debería ser 'Tobias'");
        System.out.println("getSetNombre: El nombre inicial es " + empleado.getNombre());

        empleado.setNombre("Ross");
        assertEquals("Ross", empleado.getNombre(), "El nombre debería haber cambiado a 'Ross'");
        System.out.println("getSetNombre: El nombre actualizado es " + empleado.getNombre());
    }

    /**
     * Prueba que verifica el getter y setter para el correo del empleado.
     * Se asegura de que el correo se establezca y recupere correctamente.
     */
    @Test
    @DisplayName("Test de obtener y establecer correo del empleado")
    void getSetCorreo() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        assertEquals("toperez@gmail.com", empleado.getCorreo(), "El correo debería ser 'toperez@gmail.com'");
        System.out.println("getSetCorreo: El correo inicial es " + empleado.getCorreo());

        empleado.setCorreo("rosslynch@gmail.com");
        assertEquals("rosslynch@gmail.com", empleado.getCorreo(), "El correo debería haber cambiado a 'rosslynch@gmail.com'");
        System.out.println("getSetCorreo: El correo actualizado es " + empleado.getCorreo());
    }

    /**
     * Prueba que verifica la funcionalidad de invitar a un empleado.
     * Se asegura de que el empleado pueda ser invitado correctamente.
     */
    @Test
    @DisplayName("Test de invitar a un empleado")
    void invitar() {
        Empleado empleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        empleado.invitar();
        System.out.println("invitar: Invitación realizada correctamente para " + empleado.getNombre() + " " + empleado.getApellidos());
    }
}