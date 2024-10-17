import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Asistencia {
    private Empleado empleado;
    private boolean asistio;
    private Retraso retraso;

    private Instant horaInicio;
    private Reunion reunion;
    private List<Empleado> ausentes;
    private List<Empleado> presentes;
    private List<Retraso> retrasos;

    public Asistencia(Empleado empleado, Reunion reunion, Instant horaInicio) {
        this.empleado = empleado;
        this.reunion = reunion;
        this.horaInicio = horaInicio;
        this.asistio = false;
        this.retraso = null;
        this.ausentes = new ArrayList<>();
        this.presentes = new ArrayList<>();
        this.retrasos = new ArrayList<>();
    }

    public void marcarAsistencia(boolean asistio) {
        this.asistio = asistio;
        if (!asistio) {
            ausentes.add(empleado);
        }
    }

    public void addRetrasado(Retraso retraso) {
        if (!retraso.equals(this.retraso)) {
            this.retrasos.add(retraso); // Agregar el empleado a la lista de no asistidos
            this.retraso = retraso; // Actualizar el último retraso
        }
    }
    public List<Empleado> getAusentes() {
        return ausentes; // Retornar la lista de ausentes
    }

    public List<Empleado> getPresentes() {
        return presentes; // Retornar la lista de presentes
    }

    public List<Retraso> getRetrasos() {
        return retrasos; // Retornar la lista de retrasos
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    @Override
    public String toString() {
        String ausentesNombres = "";
        for (int i = 0; i < ausentes.size(); i++) {
            if (i > 0) {
                ausentesNombres += ", ";
            }
            ausentesNombres += ausentes.get(i).getNombre();
        }

        String presentesNombres = "";
        for (int i = 0; i < presentes.size(); i++) {
            if (i > 0) {
                presentesNombres += ", ";
            }
            presentesNombres += presentes.get(i).getNombre();
        }

        return "Asistencia{" +
                "empleado=" + empleado.getNombre() +
                ", asistio=" + asistio +
                ", retraso=" + (retraso != null ? retraso : "Ninguno") +
                ", ausentes=[" + ausentesNombres + "]" +
                ", presentes=[" + presentesNombres + "]" +
                ", retrasos=" + retrasos +
                '}';
    }

}
