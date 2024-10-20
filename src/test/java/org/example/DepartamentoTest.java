package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {

    @Test
    @DisplayName("Test de agregar empleados al departamento")
    void addEmpleados() {
        Departamento departamento = new Departamento("Recursos Humanos");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        assertEquals(2, departamento.obtenerCantidadEmpleados(), "Debería haber 2 empleados en el departamento");
        System.out.println("addEmpleados: Prueba completada con éxito.");
    }


    @Test
    @DisplayName("Test de obtener empleados del departamento")
    void getEmpleados() {
        Departamento departamento = new Departamento("Recursos Humanos");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        assertTrue(departamento.getEmpleados().contains(empleado1), "El departamento debería contener al empleado 1");
        assertTrue(departamento.getEmpleados().contains(empleado2), "El departamento debería contener al empleado 2");
        System.out.println("getEmpleados: Prueba completada con éxito.");
    }


    @Test
    @DisplayName("Test de obtener cantidad de empleados del departamento")
    void obtenerCantidadEmpleados() {
        Departamento departamento = new Departamento("Recursos Humanos");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");

        departamento.addEmpleados(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "Debería haber 1 empleado en el departamento");

        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");
        departamento.addEmpleados(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados(), "Debería haber 2 empleados en el departamento");
    }


    @Test
    @DisplayName("Test de obtener nombre del departamento")
    void getNombre() {
        Departamento departamento = new Departamento("Recursos Humanos");
        assertEquals("Recursos Humanos", departamento.getNombre(), "El nombre del departamento debería ser 'Recursos Humanos'");
        System.out.println("getNombre: Prueba completada con éxito.");
    }


    @Test
    @DisplayName("Test de cambiar nombre del departamento")
    void setNombre() {
        Departamento departamento = new Departamento("Recursos Humanos");
        departamento.setNombre("Finanzas");
        assertEquals("Finanzas", departamento.getNombre(), "El nombre del departamento debería haber cambiado a 'Finanzas'");
        System.out.println("setNombre: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de invitar a los empleados del departamento")
    void invitar() {
        Departamento departamento = new Departamento("Marketing");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        departamento.invitar();
        System.out.println("invitar: Prueba completada con éxito.");

    }

    @Test
    @DisplayName("Test de invitar sin empleados")
    void invitarSinEmpleados() {
        Departamento departamento = new Departamento("Marketing");
        departamento.invitar();
        System.out.println("invitarSinEmpleados: Prueba completada con éxito.");
    }
}