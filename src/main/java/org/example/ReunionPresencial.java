package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * La clase {@code ReunionPresencial} representa una reunión que se lleva a cabo en una ubicación física específica, 
 * con una sala asignada.
 * Hereda de la clase abstracta {@code Reunion}.
 * 
 * <p>Incluye la información de la sala en la que se llevará a cabo la reunión y sobrescribe los métodos 
 * {@code iniciar} y {@code finalizar} para registrar el inicio y el fin de la reunión presencial.</p>
 * 
 * @see Reunion
 */
public class ReunionPresencial extends Reunion {
    /**
     * Sala en la que se llevará a cabo la reunión presencial.
     */
    private String sala;

    /**
     * Constructor para inicializar una reunión presencial con fecha, hora, duración y sala asignada.
     * 
     * @param fecha           La fecha de la reunión.
     * @param horaPrevista    La hora prevista de inicio de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param sala            La sala donde se llevará a cabo la reunión.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala) {
        super(fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

    /**
     * Obtiene la sala asignada para la reunión.
     * 
     * @return El nombre o número de la sala.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Establece la sala para la reunión.
     * 
     * @param sala El nombre o número de la sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Inicia la reunión presencial, registrando la hora de inicio y mostrando un mensaje con la sala.
     */
    @Override
    public void iniciar() {
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        System.out.println("Reunión presencial iniciada en la sala: " + sala + " a las: " + getHorarioInicio());
    }

    /**
     * Finaliza la reunión presencial, registrando la hora de fin y mostrando un mensaje con la sala.
     */
    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión presencial finalizada en la sala: " + sala + " a las: " + getHoraFin());
    }

    /**
     * Devuelve una representación en formato de cadena de la reunión presencial.
     * 
     * @return Una cadena que incluye la información de la reunión y la sala asignada.
     */
    @Override
    public String toString() {
        // Llamamos al toString() de la clase padre y agregamos la información adicional de la sala
        return super.toString() + ", sala='" + sala + '\'';
    }
}
