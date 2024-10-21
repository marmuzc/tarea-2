package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase ReunionPresencial.
 * Contiene pruebas unitarias para los métodos de la clase ReunionPresencial.
 */
class ReunionPresencialTest {
    Date fechaReunion = new Date();
    Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
    Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
    Empleado organizador = new Empleado("120", "Perez", "Juan", "@gmail.com");
    Empleado empleado =  new Empleado("1", "Perez", "Juan", "jperez@gmail.com");
    Empleado empleado2 = new Empleado("2", "Lopez", "Carlos", "clopez@gmail.com");
    Empleado empleado3 = new Empleado("3", "Gomez", "Maria", "margome@gmail.com");
    ListaInvitacion invitacion;
    tipoReunion tipo = tipoReunion.OTRO;
    String sala = "Sala 1";
    ReunionPresencial reunionPresencial = new ReunionPresencial(fechaReunion, horaPrevista, duracionPrevista, tipo, sala, organizador);

    /**
     * Prueba que verifica la obtención de la sala de la reunión.
     * Se asegura de que la sala sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de obtener la sala de la reunión")
    void getSala() {
        assertEquals("Sala 1", reunionPresencial.getSala(), "La sala debería ser la misma que se estableció en la reunión");
        System.out.println("getSala: Prueba completada con éxito.");
        System.out.println("Sala: " + reunionPresencial.getSala());
    }

    /**
     * Prueba que verifica el establecimiento de la sala de la reunión.
     * Se asegura de que la sala sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de establecer la sala de la reunión")
    void setSala() {
        reunionPresencial.setSala("Sala 2");
        assertEquals("Sala 2", reunionPresencial.getSala(), "La sala debería ser la misma que se estableció en la reunión");
        System.out.println("setSala: Prueba completada con éxito.");
        System.out.println("Sala: " + reunionPresencial.getSala());
    }

    /**
     * Prueba que verifica el inicio de la reunión presencial.
     * Se asegura de que la reunión haya comenzado y tenga un horario de inicio definido.
     */
    @Test
    @DisplayName("Test de iniciar reunión presencial")
    void testIniciarReunionPresencial() {
        reunionPresencial.iniciar();
        assertNotNull(reunionPresencial.getHorarioInicio(), "La reunión debería haber comenzado y tener un horario de inicio definido.");
        System.out.println("Reunión iniciada con éxito: " + reunionPresencial);
    }

    /**
     * Prueba que verifica la finalización de la reunión.
     * Se asegura de que la reunión haya finalizado y tenga un horario de fin definido.
     */
    @Test
    @DisplayName("Test de finalizar la reunión")
    void finalizar() {
        reunionPresencial.finalizar();
        assertNotNull(reunionPresencial.getHoraFin(), "La reunión debería haber finalizado y tener un horario de fin definido.");
        System.out.println("Reunión finalizada con éxito: " + reunionPresencial);
    }
}