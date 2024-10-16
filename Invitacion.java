import java.time.Instant;

public class Invitacion {
    private Empleado empleado;
    private Instant hora; // Hora de la invitación
    private Asistencia asistencia; // Objeto de asistencia asociado

    public Invitacion(Empleado empleado) {
        this.empleado = empleado;
        this.hora = Instant.now(); // Hora de invitación
        this.asistencia = null; // Inicialmente, no hay asistencia registrada
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHora() {
        return hora;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "empleado=" + empleado.getNombre() + " " + empleado.getApellidos() +
                ", hora=" + hora +
                ", asistencia=" + (asistencia != null ? asistencia.toString() : "No registrada") +
                '}';
    }
}
