package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase ReunionVirtual.
 * Contiene pruebas unitarias para los métodos de la clase ReunionVirtual.
 */
class ReunionVirtualTest {
    Date fechaReunion = new Date();
    Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
    Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
    Empleado organizador = new Empleado("120", "Perez", "Juan", "@gmail.com");
    Empleado empleado =  new Empleado("1", "Perez", "Juan", "jperez@gmail.com");
    Empleado empleado2 = new Empleado("2", "Lopez", "Carlos", "clopez@gmail.com");
    Empleado empleado3 = new Empleado("3", "Gomez", "Maria", "margome@gmail.com");
    tipoReunion tipo = tipoReunion.OTRO;
    String enlace = "https://meet.google.com/abc-123";
    ReunionVirtual reunionVirtual = new ReunionVirtual(fechaReunion, horaPrevista, duracionPrevista, tipo, enlace, organizador);

    /**
     * Prueba que verifica la obtención del enlace de la reunión.
     * Se asegura de que el enlace sea el mismo que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de obtener enlace de la reunión")
    void getEnlace() {
        assertEquals("https://meet.google.com/abc-123", reunionVirtual.getEnlace(), "El enlace debe ser el mismo que se estableció en la reunión");
        System.out.println("getEnlace: Prueba completada con éxito.");
        System.out.println("Enlace: " + reunionVirtual.getEnlace());
    }

    /**
     * Prueba que verifica el establecimiento del enlace de la reunión.
     * Se asegura de que el enlace sea el mismo que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de establecer enlace de la reunión")
    void setEnlace() {
        reunionVirtual.setEnlace("Enlace 2");
        assertEquals("Enlace 2", reunionVirtual.getEnlace(), "El enlace debería ser el mismo que se estableció en la reunión");
        System.out.println("setEnlace: Prueba completada con éxito.");
        System.out.println("Enlace: " + reunionVirtual.getEnlace());
    }

    /**
     * Prueba que verifica el inicio de la reunión virtual.
     * Se asegura de que la reunión haya comenzado y tenga un horario de inicio definido.
     */
    @Test
    @DisplayName("Test de iniciar reunión virtual")
    void testIniciarReunionVirtual() {
        reunionVirtual.iniciar();
        assertNotNull(reunionVirtual.getHorarioInicio(), "La reunión debería haber comenzado y tener un horario de inicio definido.");
        System.out.println("Reunión iniciada con éxito: " + reunionVirtual);
    }

    /**
     * Prueba que verifica la finalización de la reunión.
     * Se asegura de que la reunión haya finalizado y tenga un horario de fin definido.
     */
    @Test
    @DisplayName("Test de finalizar la reunión")
    void testFinalizarReunion() {
        reunionVirtual.finalizar();
        assertNotNull(reunionVirtual.getHoraFin(), "La reunión debería haber finalizado y tener un horario de fin definido.");
        System.out.println("Reunión finalizada con éxito: " + reunionVirtual);
    }
}