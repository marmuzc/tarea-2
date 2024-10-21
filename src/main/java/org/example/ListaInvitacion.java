package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase {@code ListaInvitacion} gestiona la programación y envío de invitaciones.
 * Permite agregar invitados, enviar las invitaciones y consultar detalles.
 */
public class ListaInvitacion {
    /** Hora en la que se realizará el evento. */
    private Instant hora;

    /** Lista de invitados que implementan la interfaz {@code Invitable}. */
    private List<Invitable> invitados;

    /**
     * Crea una nueva instancia de {@code ListaInvitacion} con la hora especificada.
     *
     * @param hora La hora del evento.
     */
    public ListaInvitacion(Instant hora) {
        this.hora = hora;
        this.invitados = new ArrayList<>();
    }

    /**
     * Agrega un empleado a la lista de invitados.
     *
     * @param empleado El empleado que se añadirá como invitado.
     */
    public void agregarEmpleados(Invitable empleado) {
        invitados.add(empleado);
    }

    /**
     * Agrega una lista de departamentos a la lista de invitados.
     *
     * @param departamento La lista de departamentos que se añadirán como invitados.
     */
    public void agregarDepartamentos(List<Invitable> departamento) {
        invitados.addAll(departamento);
    }

    /**
     * Envía la invitación a todos los invitados de la lista.
     */
    public void sendInvitacion() {
        for (Invitable invitado : invitados) {
            invitado.invitar();
        }
    }

    /**
     * Devuelve el total de invitaciones enviadas.
     *
     * @return El número total de invitados.
     */
    public int totalInvitaciones() {
        return invitados.size();
    }

    /**
     * Devuelve la lista de invitados.
     *
     * @return La lista de objetos que implementan {@code Invitable}.
     */
    public List<Invitable> getInvitados() {
        return invitados;
    }

    /**
     * Verifica si un empleado específico ha sido invitado.
     *
     * @param empleado El empleado que se busca en la lista de invitados.
     * @return {@code true} si el empleado está invitado, {@code false} en caso contrario.
     */
    public boolean esInvitado(Empleado empleado) {
        return invitados.contains(empleado);
    }

    /**
     * Devuelve la hora del evento.
     *
     * @return La hora de la invitación.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Establece una nueva hora para el evento.
     *
     * @param hora La nueva hora del evento.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia {@code ListaInvitacion}.
     * 
     * @return Una cadena que representa la invitación con la hora y el número total de invitados.
     */
    @Override
    public String toString() {
        return String.format("ListaInvitacion{hora=%s, total de invitados=%d}", hora, invitados.size());
    }
}
