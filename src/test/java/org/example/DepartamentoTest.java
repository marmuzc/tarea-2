package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    private Empleado empleado;

    @Test
    @DisplayName("Test de agregar empleados al departamento")
    void addEmpleados() {
        Departamento departamento = new Departamento("Marketing");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        assertEquals(2, departamento.obtenerCantidadEmpleados(), "Debería haber 2 empleados en el departamento");

        System.out.println("Empleados agregados:");
        for (Invitable empleado : departamento.getEmpleados()) {
            System.out.println(empleado.toString());
        }

        System.out.println("addEmpleados: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de obtener empleados del departamento")
    void getEmpleados() {
        Departamento departamento = new Departamento("Marketing");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");
        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");


        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        assertTrue(departamento.getEmpleados().contains(empleado1), "El departamento debería contener al empleado 1");
        assertTrue(departamento.getEmpleados().contains(empleado2), "El departamento debería contener al empleado 2");

        System.out.println("Empleados obtenidos:");
        for (Invitable empleado : departamento.getEmpleados()) {
            System.out.println(empleado.toString());
        }

        System.out.println("getEmpleados: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de obtener cantidad de empleados del departamento")
    void obtenerCantidadEmpleados() {
        Departamento departamento = new Departamento("Marketing");
        Empleado empleado1 = new Empleado("1", "Perez", "Tobias", "toperez@gmail.com");


        departamento.addEmpleados(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "Debería haber 1 empleado en el departamento");

        Empleado empleado2 = new Empleado("2", "Lynch", "Ross", "rosslynch@gmail.com");

        departamento.addEmpleados(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados(), "Debería haber 2 empleados en el departamento");

        System.out.println("Cantidad de empleados: " + departamento.obtenerCantidadEmpleados());

        System.out.println("obtenerCantidadEmpleados: Prueba completada con éxito.");
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

        System.out.println("Empleados invitados:");
        for (Invitable empleado : departamento.getEmpleados()) {
            System.out.println(empleado.toString());
        }

        System.out.println("invitar: Prueba completada con éxito.");
    }

    @Test
    @DisplayName("Test de invitar sin empleados")
    void invitarSinEmpleados() {
        Departamento departamento = new Departamento("Marketing");

        departamento.invitar();
        System.out.println("invitarSinEmpleados: Prueba completada con éxito.");
        System.out.println("Se invito al departamento sin empleados.");
    }
}
