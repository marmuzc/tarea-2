import java.time.Instant;

public class Invitacion {
    private Instant hora; // Hora de la invitación

    public Invitacion(Instant hora) {
        this.hora = hora; // Hora de invitación
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora){ //No definitivo
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                ", hora=" + hora +
                '}';
    }
}
