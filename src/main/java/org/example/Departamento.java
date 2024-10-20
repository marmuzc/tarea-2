package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase {@code Departamento} representa un departamento que contiene una lista de empleados.
 * Implementa la interfaz {@code Invitable} para que se pueda invitar a todos los empleados del departamento.
 */
public class Departamento implements Invitable {

    /** Nombre del departamento. */
    private String nombre;

    /** Lista de empleados asociados al departamento (agregación). */
    private List<Empleado> empleados;

    /**
     * Crea una nueva instancia de {@code Departamento} con el nombre especificado.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado El empleado que se añadirá al departamento.
     */
    public void addEmpleados(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Devuelve la lista de empleados del departamento.
     *
     * @return Una lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Devuelve la cantidad de empleados en el departamento.
     *
     * @return El número de empleados.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     * Devuelve el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Implementación del método {@code invitar} de la interfaz {@code Invitable}.
     * Envía una invitación a todos los empleados del departamento.
     */
    @Override
    public void invitar() {
        System.out.println("Se invitó a todos los empleados del departamento " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar();
        }
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia {@code Departamento}.
     *
     * @return Una cadena con el formato: {@code Departamento{nombre='...', numero de empleados=...}}.
     */
    @Override
    public String toString() {
        return String.format(
            "Departamento{nombre='%s', numero de empleados=%d}", 
            nombre, obtenerCantidadEmpleados()
        );
    }
}
