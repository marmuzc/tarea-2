import java.time.Duration;
import java.time.Instant;
import java.util.Date;

<<<<<<< HEAD
public class reunionVirtual extends Reunion {
    private String enlace;

    public reunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace, Invitacion invitacion, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, invitacion, organizador);
=======
class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(fecha, horaPrevista, duracionPrevista);
>>>>>>> test-new-logic
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }
<<<<<<< HEAD
=======

>>>>>>> test-new-logic
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

<<<<<<< HEAD
    public void iniciar() {
        setHorarioInicio(Instant.now());
        System.out.println("Reunión virtual iniciada en el enlace: " + enlace + " a las: " + getHorarioInicio());
=======
    @Override
    public void iniciar() {
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        System.out.println("Reunión virtual iniciada con enlace: " + enlace + " a las: " + getHorarioInicio());
>>>>>>> test-new-logic
    }

    @Override
    public void finalizar() {
<<<<<<< HEAD
        setHoraFin(Instant.now());
        System.out.println("Reunión virtual finalizada en el enlace: " + enlace + " a las: " + getHoraFin());
    }

    public String toString( ){
=======
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión virtual finalizada con enlace: " + enlace + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        // Llamamos al toString() de la clase padre y agregamos la información adicional del enlace
>>>>>>> test-new-logic
        return super.toString() + ", enlace='" + enlace + '\'';
    }
}
