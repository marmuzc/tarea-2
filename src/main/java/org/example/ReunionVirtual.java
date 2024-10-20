package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class ReunionVirtual extends Reunion {
    private String enlace;
    private Empleado organizador;
    private tipoReunion tipoReunion;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion, String enlace, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, organizador);
        this.enlace = enlace;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;
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
        // Llamamos al toString() de la clase padre y agregamos la información adicional
        return super.toString() +
                ", enlace='" + enlace + '\'' +
                ", organizador=" + organizador.getNombre() +
                ", tipoReunion=" + getTipo(); // Usar el método getter para obtener el tipo
    }

}
