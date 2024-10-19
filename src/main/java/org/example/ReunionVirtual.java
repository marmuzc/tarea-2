package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public void iniciar() {
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        System.out.println("Reunión virtual iniciada con enlace: " + enlace + " a las: " + getHorarioInicio());
    }

    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión virtual finalizada con enlace: " + enlace + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        // Llamamos al toString() de la clase padre y agregamos la información adicional del enlace
        return super.toString() + ", enlace='" + enlace + '\'';
    }
}
