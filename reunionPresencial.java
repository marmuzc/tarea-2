import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class reunionPresencial extends Reunion {
    private String sala;

    public reunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala, Invitacion invitacion) {
        super(fecha, horaPrevista, duracionPrevista, invitacion);
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
        setHorarioInicio(Instant.now()); // Se marca la hora de inicio
        System.out.println("Reunión presencial iniciada en la sala: " + sala + " a las: " + getHorarioInicio());
    }


    @Override
    public void finalizar() {
        setHoraFin(Instant.now());
        System.out.println("Reunión presencial finalizada en la sala: " + sala + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        return super.toString() + ", sala='" + sala + '\'';
    }
}
