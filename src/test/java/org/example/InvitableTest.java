package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la interfaz Invitable.
 * Contiene pruebas unitarias para los métodos de invitar de la interfaz Invitable.
 */
class InvitableTest {

    /**
     * Prueba que verifica la funcionalidad de invitar a un empleado desde la interfaz Invitable.
     * Se asegura de que el método invitar se ejecute correctamente para un empleado.
     */
    @Test
    @DisplayName("Test de invitar a un empleado desde Invitable")
    void invitar() {
        Invitable invitableEmpleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");

        invitableEmpleado.invitar();

        System.out.println("invitar: Prueba de la interfaz Invitable completada.");
    }

    /**
     * Prueba que verifica la funcionalidad de invitar a un departamento desde la interfaz Invitable.
     * Se asegura de que el método invitar se ejecute correctamente para un departamento.
     */
    @Test
    @DisplayName("Test de invitar a un departamento desde Invitable")
    void invitarDepartamento() {
        Invitable invitableDepartamento = new Departamento("Marketing");

        invitableDepartamento.invitar();

        System.out.println("invitarDepartamento: Prueba de la interfaz Invitable completada.");
    }
}