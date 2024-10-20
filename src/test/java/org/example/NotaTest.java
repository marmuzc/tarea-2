package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {

    @Test
    @DisplayName("Test de creación de nota")
    void crearNota() {
        String contenido = "Esta es una nota de prueba.";
        Nota nota = new Nota(contenido);

        assertNotNull(nota, "La nota no debería ser nula después de ser creada.");
        System.out.println("crearNota: Prueba completada con éxito.");
        System.out.println("Nota creada: " + nota.toString());
    }

    @Test
    @DisplayName("Test de obtener contenido de la nota")
    void getContenido() {
        String contenido = "Este es el contenido de la nota.";
        Nota nota = new Nota(contenido);

        assertEquals(contenido, nota.getContenido(), "El contenido de la nota debería ser el mismo que se estableció al crearla.");
        System.out.println("getContenido: Prueba completada con éxito.");
        System.out.println("Contenido de la nota: " + nota.getContenido());
    }

    @Test
    @DisplayName("Test de contenido vacío en nota")
    void contenidoVacio() {
        String contenido = "";
        Nota nota = new Nota(contenido);

        assertEquals(contenido, nota.getContenido(), "El contenido de la nota debería ser vacío.");
        System.out.println("contenidoVacio: Prueba completada con éxito.");
        System.out.println("Contenido de la nota: " + nota.getContenido());
    }

    @Test
    @DisplayName("Test de contenido nulo en nota")
    void contenidoNulo() {
        Nota nota = new Nota(null);

        assertNull(nota.getContenido(), "El contenido de la nota debería ser nulo.");
        System.out.println("contenidoNulo: Prueba completada con éxito.");
        System.out.println("Contenido de la nota: " + nota.getContenido());
    }

    @Test
    @DisplayName("Test de toString de la nota")
    void testToString() {
        String contenido = "Contenido de prueba.";
        Nota nota = new Nota(contenido);

        String expectedString = "Nota{contenido='Contenido de prueba.'}";
        assertEquals(expectedString, nota.toString(), "toStrinf de la nota debería coincidir con el formato esperado.");
        System.out.println("testToString: Prueba completada con éxito.");
        System.out.println("toString de la nota: " + nota.toString());
    }
}
