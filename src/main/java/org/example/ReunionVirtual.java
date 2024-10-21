package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * La clase {@code ReunionVirtual} representa una reunión que se lleva a cabo de manera virtual 
 * a través de un enlace en línea.
 * 
 * <p>Hereda de la clase abstracta {@code Reunion} e incluye la información del enlace de la reunión. 
 * Además, sobrescribe los métodos {@code iniciar} y {@code finalizar} para registrar el inicio y fin de la reunión virtual.</p>
 * 
 * @see Reunion
 */
public class ReunionVirtual extends Reunion {
    /**
     * Enlace de la reunión virtual.
     */
    private String enlace;
    /**
     * Empleado que organiza la reunió.
     */
    private Empleado organizador;
    /**
     * Tipo de la reunión que se va a iniciar.
     */
    private tipoReunion tipoReunion;

    /**
     * Constructor para inicializar una reunión virtual con fecha, hora, duración y enlace asignado.
     * 
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista de inicio de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param tipoReunión     El tipo de la reunión que se va a iniciar.
     * @param enlace           El enlace de la reunión virtual.
     * @param organizador     El empleado que organizará la reunión.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion, String enlace, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, organizador);
        this.enlace = enlace;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;
    }

    /**
     * Obtiene el enlace de la reunión virtual.
     * 
     * @return El enlace de la reunión.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Establece el enlace de la reunión virtual.
     * 
     * @param enlace El enlace de la reunión.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    /**
     * Inicia la reunión virtual, registrando la hora de inicio y mostrando un mensaje con el enlace.
     */
    @Override
    public void iniciar() {
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        // Formatear y mostrar la hora de inicio
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String horarioInicioFormatted = LocalDateTime.ofInstant(getHorarioInicio(), ZoneId.systemDefault()).format(formatter);
        System.out.println("\nReunión virtual iniciada con enlace: " + enlace +"a las: " + horarioInicioFormatted);
    }

    /**
     * Finaliza la reunión virtual, registrando la hora de fin y mostrando un mensaje con el enlace.
     */
    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        // Formatear y mostrar la hora de fin
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        String horarioFinFormatted = LocalDateTime.ofInstant(getHoraFin(), ZoneId.systemDefault()).format(formatter);
        System.out.println("\nReunión virtual finalizada con enlace: " + enlace + " a las: " + horarioFinFormatted);
    }

    /**
     * Devuelve una representación en formato de cadena de la reunión virtual.
     * 
     * @return Una cadena que incluye la información de la reunión y el enlace de la reunión virtual.
     */
    @Override
    public String toString() {
        return super.toString() + 
                ", enlace='" + enlace + '\''+
                ", organizador=" + organizador.getNombre() +
                ", tipoReunion=" + getTipo();
    }
}
