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
    protected List<Invitacion> invitaciones;

    private Nota nota;

    protected List<Empleado> invitados;
    protected Asistencia asistencia;


    //cada reunión tiene una fecha, hora, duración prevista y lista de invitación (con sus
    //horas). Cada reunión debe tener un organizador.
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;

        this.invitados = new ArrayList<>();
        this.asistencia = new Asistencia(invitados, horaPrevista);
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
        asistentes = asistencia.getPresentes();
        return asistentes;
    }

    public List<Empleado> obtenerAusencias() {
        List<Empleado> asistentes = new ArrayList<>();
        asistentes = asistencia.getPresentes();

        List<Empleado> ausentes = new ArrayList<>();
        for (Empleado empleado : invitados) {
            if (!asistentes.contains(empleado)) {
                ausentes.add(empleado);
            }
        }
        return ausentes;
    }

    public List<Empleado> obtenerRetrasos() {
        List<Empleado> retrasados = new ArrayList<>();
        retrasados = asistencia.getRetrasados();
        return retrasados;
    }

    public int obtenerTotalAsistencia() {
        return asistencia.getPresentes().size();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitaciones.size(); //Arreglar esta parte al hacer lista de invitaciones
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

