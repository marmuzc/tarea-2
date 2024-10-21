package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {

    @Test
    @DisplayName("Test de agregar empleados a la invitación")
    void agregarEmpleados() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        Invitable empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Invitable empleado2 = new Empleado("2", "Lynch", "Ross", "ross@gmail.com");

        invitacion.agregarEmpleados(empleado1);
        invitacion.agregarEmpleados(empleado2);

        assertTrue(invitacion.getInvitados().contains(empleado1), "El empleado debería estar en la lista de invitados");
        assertTrue(invitacion.getInvitados().contains(empleado2), "El empleado debería estar en la lista de invitados");
        System.out.println("agregarEmpleados: Prueba completada con éxito.");
        System.out.println("Empleados agregados: " + empleado1.toString() + ", " + empleado2.toString());
    }

    @Test
    @DisplayName("Test de agregar departamentos a la invitación")
    void agregarDepartamentos() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        List<Invitable> departamentos = new ArrayList<>();
        Invitable departamento1 = new Departamento("Marketing");
        Invitable departamento2 = new Departamento("Otro");
        departamentos.add(departamento1);
        departamentos.add(departamento2);

        invitacion.agregarDepartamentos(departamentos);

        assertTrue(invitacion.getInvitados().contains(departamento1), "El departamento debería estar en la lista de invitados");
        assertTrue(invitacion.getInvitados().contains(departamento2), "El departamento debería estar en la lista de invitados");
        System.out.println("agregarDepartamentos: Prueba completada con éxito.");
        System.out.println("Departamentos agregados: " + departamento1.toString() + ", " + departamento2.toString());
    }

    @Test
    @DisplayName("Test de enviar invitaciones")
    void sendInvitacion() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        Invitable empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        invitacion.agregarEmpleados(empleado1);

        invitacion.sendInvitacion();

        System.out.println("sendInvitacion: Prueba completada con éxito.");
        System.out.println("Invitación enviada a: " + empleado1.toString());
    }

    @Test
    @DisplayName("Test de obtener total de invitaciones")
    void totalInvitaciones() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        Invitable empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Invitable empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        invitacion.agregarEmpleados(empleado1);
        invitacion.agregarEmpleados(empleado2);

        assertEquals(2, invitacion.totalInvitaciones(), "Debería haber 2 invitaciones en total");
        System.out.println("totalInvitaciones: Prueba completada con éxito.");
        System.out.println("Total de invitaciones: " + invitacion.totalInvitaciones());
    }

    @Test
    @DisplayName("Test de obtener la lista de invitados")
    void getInvitados() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        Invitable empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        invitacion.agregarEmpleados(empleado1);

        List<Invitable> invitados = invitacion.getInvitados();
        assertEquals(1, invitados.size(), "Debería haber 1 invitado");
        assertTrue(invitados.contains(empleado1), "La lista de invitados debería contener al empleado1");
        System.out.println("getInvitados: Prueba completada con éxito.");
        System.out.println("Invitados: " + invitados.toString());
    }

    @Test
    @DisplayName("Test de verificar si un empleado está invitado")
    void esInvitado() {
        ListaInvitacion invitacion = new ListaInvitacion(Instant.now());
        Invitable empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        invitacion.agregarEmpleados(empleado1);

        assertTrue(invitacion.esInvitado((Empleado) empleado1), "El empleado debería estar invitado");
        System.out.println("esInvitado: Prueba completada con éxito.");
        System.out.println("El empleado " + empleado1.toString() + " está invitado.");
    }

    @Test
    @DisplayName("Test de obtener y establecer la hora de la invitación")
    void getHoraYSetHora() {
        Instant horaActual = Instant.now();
        ListaInvitacion invitacion = new ListaInvitacion(horaActual);

        assertEquals(horaActual, invitacion.getHora(), "La hora debería ser la misma que se estableció");

        Instant nuevaHora = horaActual.plusSeconds(3600);
        invitacion.setHora(nuevaHora);
        assertEquals(nuevaHora, invitacion.getHora(), "La hora debería haber cambiado a la nueva hora");
        System.out.println("getHoraYSetHora: Prueba completada con éxito.");
        System.out.println("Hora actual: " + invitacion.getHora());
    }
}
