import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Asistencia {
    private Instant horaInicio;
    private Retraso retraso;

    private List<Empleado> invitados;
    private List<Empleado> presentes;
    private List<Empleado> retrasados;

    private List<Instant> listaRetrasos;

    public Asistencia(List<Empleado> empleados, Instant horaInicio) {
        this.horaInicio = horaInicio;

        this.invitados = new ArrayList<>();
        this.presentes = new ArrayList<>();
        this.listaRetrasos = new ArrayList<>();
        this.retrasados = new ArrayList<>();
        
        for (Empleado empleado : empleados) { //Si el Empleado está invitado, se lo agrega a la lista de invitados
            if (empleado.esInvitado()) {
                invitados.add(empleado);
            }
        }
    }

    public void marcarAsistencia(Empleado empleado) {
        Instant horaLlegada = retraso.getHoraLlegada();

        if (invitados.contains(empleado)) { //Si el Empleado está invitado, se marca como presente
            presentes.add(empleado);
            if (horaLlegada.isAfter(horaInicio)) { //Si el Empleado llego despues de la hora de inicio, se marca como retrasado
                retrasados.add(empleado);
                listaRetrasos.add(horaLlegada); //Se guarda la hora de llegada del Empleado retrasado
            }
        }
    }

    public List<Empleado> getPresentes() {
        return presentes; // Retornar la lista de presentes
    }

    public List<Empleado> getRetrasados() {
        return retrasados; //Retornar la lista de retrasados
    }

    public List<Instant> getHoraRetrasos() {
        return listaRetrasos; // Retornar la lista con las horas de llegada de los retrasados
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "empleado=" + empleado.getNombre() +
                ", asistio=" + asistio +
                ", retraso=" + retraso +
                ", noAsistidos=" + noAsistidos +
                '}';
    }
}
