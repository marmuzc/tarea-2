package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala) {
        super(fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public void iniciar() {
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        System.out.println("Reunión presencial iniciada en la sala: " + sala + " a las: " + getHorarioInicio());
    }

    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión presencial finalizada en la sala: " + sala + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        // Llamamos al toString() de la clase padre y agregamos la información adicional de la sala
        return super.toString() + ", sala='" + sala + '\'';
    }
}

