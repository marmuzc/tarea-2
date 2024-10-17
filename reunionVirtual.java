import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class reunionVirtual extends Reunion {
    private String enlace;

    public reunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace, Invitacion invitacion, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, invitacion, organizador);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public void iniciar() {
        setHorarioInicio(Instant.now());
        System.out.println("Reunión virtual iniciada en el enlace: " + enlace + " a las: " + getHorarioInicio());
    }

    @Override
    public void finalizar() {
        setHoraFin(Instant.now());
        System.out.println("Reunión virtual finalizada en el enlace: " + enlace + " a las: " + getHoraFin());
    }

    public String toString( ){
        return super.toString() + ", enlace='" + enlace + '\'';
    }
}

