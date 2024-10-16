import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horaFin;
    private Nota nota;

    protected List<Invitacion> Invitaciones;
    private tipoReunion organizador;

    private List<Retraso> Retrasos;

    //cada reunión tiene una fecha, hora, duración prevista y lista de invitación (con sus
    //horas). Cada reunión debe tener un organizador.
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Invitacion Invitaciones, tipoReunion organizador) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.Invitaciones = new ArrayList<>();
        this.Retrasos = new ArrayList<>();
        this.Invitaciones.add(Invitaciones);
        this.nota = new Nota("Nota de la reunión");
        this.organizador = organizador;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public Instant getHorarioInicio() {
        return horarioInicio;
    }
    public void setHorarioInicio(Instant horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public Nota getNota() {
        return nota;
    }
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public List<Empleado> obtenerAsistencias() {
        List<Empleado> asistentes = new ArrayList<>();
        for (Invitacion invitacion : Invitaciones) {
            if (invitacion.Asistio()) {
                asistentes.add(invitacion.getEmpleado());
            }
        }
        return asistentes;
    }

    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>();
        for (Invitacion invitacion : Invitaciones) {
            if (!invitacion.Asistio()) {
                ausentes.add(invitacion.getEmpleado());
            }
        }
        return ausentes;
    }

    public List<Empleado> obtenerRetrasos() {
        List<Empleado> retrasados = new ArrayList<>();
            for (Invitacion invitacion : Invitaciones) {
            if (invitacion.Retrasado()) {
                retrasados.add(invitacion.getEmpleado());
            }
        }
        return retrasados;
    }

    public int obtenerTotalAsistencia() {
        return obtenerAsistencias().size();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = Invitaciones.size();
        if (totalInvitados == 0) {
            return 0.0f;
        }
        return (float) obtenerTotalAsistencia() / totalInvitados * 100;
    }

    public float calcularTiempoReal() {
        if (horarioInicio != null && horaFin != null) {
            Duration duracionReal = Duration.between(horarioInicio, horaFin);
            return duracionReal.toMinutes();
        }
        return 0.0f;
    }

    public void iniciar() {
        this.horarioInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista.toMinutes() + " minutos" +
                ", horarioInicio=" + horarioInicio +
                ", horaFin=" + horaFin +
                ", total de asistencias=" + obtenerTotalAsistencia() +
                ", total de ausencias=" + obtenerAusencias().size() +
                ", total de retrasos=" + obtenerRetrasos().size() +
                ", porcentaje de asistencia=" + obtenerPorcentajeAsistencia() + "%" +
                ", duracion real=" + calcularTiempoReal() + " minutos" +
                "notas" + nota +
                '}';
    }

}

