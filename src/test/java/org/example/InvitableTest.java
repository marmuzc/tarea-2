package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InvitableTest {

    @Test
    @DisplayName("Test de invitar a un empleado desde Invitable")
    void invitar() {
        Invitable invitableEmpleado = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");

        invitableEmpleado.invitar();

        System.out.println("invitar: Prueba de la interfaz Invitable completada.");
    }

    @Test
    @DisplayName("Test de invitar a un departamento desde Invitable")
    void invitarDepartamento() {
        Invitable invitableDepartamento = new Departamento("Marketing");

        invitableDepartamento.invitar();

        System.out.println("invitarDepartamento: Prueba de la interfaz Invitable completada.");
    }
}
