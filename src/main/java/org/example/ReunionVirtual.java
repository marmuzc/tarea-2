package org.example;

import java.time.Duration;
import java.time.Instant;
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
     * Constructor para inicializar una reunión virtual con fecha, hora, duración y enlace asignado.
     * 
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista de inicio de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param enlace           El enlace de la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
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
        System.out.println("Reunión virtual iniciada con enlace: " + enlace + " a las: " + getHorarioInicio());
    }

    /**
     * Finaliza la reunión virtual, registrando la hora de fin y mostrando un mensaje con el enlace.
     */
    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión virtual finalizada con enlace: " + enlace + " a las: " + getHoraFin());
    }

    /**
     * Devuelve una representación en formato de cadena de la reunión virtual.
     * 
     * @return Una cadena que incluye la información de la reunión y el enlace de la reunión virtual.
     */
    @Override
    public String toString() {
        return super.toString() + ", enlace='" + enlace + '\'';
    }
}
