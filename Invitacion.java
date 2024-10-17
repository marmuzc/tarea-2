import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Invitacion {
    private Instant hora;
    private List<Invitable> invitados;

    public Invitacion(Instant hora) {
        this.hora = hora;
        this.invitados = new ArrayList<>();
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public void agregarInvitado(Invitable invitado) {
        invitados.add(invitado);
        invitado.invitar(this);
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
                ", invitados=" + invitados +
                '}';
    }
}
