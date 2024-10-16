import java.time.Instant;

public class Retraso {
    private Instant horaLlegada;

    public Retraso() {
        this.horaLlegada = Instant.now(); // Marca la hora en que llegó tarde
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    @Override
    public String toString() {
        return "Retraso{horaLlegada=" + horaLlegada + '}';
    }
}
