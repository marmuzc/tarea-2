import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant horaLlegada;

    public Retraso(Empleado empleado, Instant horaLlegada) {
        super(empleado, horaLlegada);
        this.horaLlegada = Instant.now(); //tomamos la hora actual como hora de llegada
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    @Override
    public String toString() {
        return "Retraso{" +
                "empleado=" + getEmpleado().getNombre() +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
