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

    protected Invitacion invitacion; //Invitación es parte de Reunión

    private Nota nota;

    protected List<Asistencia> listaAsistencias;
    protected List<Retraso> listaRetrasos;


    //cada reunión tiene una fecha, hora, duración prevista y lista de invitación (con sus
    //horas). Cada reunión debe tener un organizador.
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;

        this.invitacion = new Invitacion(horaPrevista); //Composición, se crea invitación dentro de Reunion
        this.listaAsistencias = new ArrayList<>();
        this.listaRetrasos = new ArrayList<>();
    }

    public Nota getNota() {
        return nota;
    }
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void marcarAsistencia(Empleado empleado, Instant horaLlegada) {
        if (invitacion.esInvitado(empleado)) {
            if (horarioInicio != null) {  // Aseguramos que la reunión ya haya comenzado
                if (horaLlegada.isAfter(horarioInicio)) {
                    // Si el empleado llega después de la hora de inicio, se considera retraso
                    Retraso retraso = new Retraso(empleado, horaLlegada);
                    listaRetrasos.add(retraso);
                    listaAsistencias.add(retraso);
                } else if (horaLlegada.equals(horarioInicio) || horaLlegada.isBefore(horarioInicio)) { //si la hora de llegada es igual o antes de la hora de inicio
                    // el empleado llega a tiempo o antes de la hora de inicio, se considera asistencia
                    Asistencia asistencia = new Asistencia(empleado, horaLlegada);
                    listaAsistencias.add(asistencia);
                }
            } else {
                System.out.println("La reunión aún no ha comenzado.");
            }
        } else {
            System.out.println("El empleado no está invitado.");
        }
    }


    //Metodos Mencionados en UML
    public List<Asistencia> obtenerAsistencias() {
        return listaAsistencias;
    }

    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>();
        for (Invitable invitado : invitacion.getInvitados()) {
            Empleado empleado = (Empleado) invitado; // Suponemos que todos los Invitable son instancias de Empleado
            boolean asistio = false;
            // Verificamos si este invitado está en la lista de asistencias
            for (Asistencia asistencia : listaAsistencias) {
                if (asistencia.getEmpleado().equals(empleado)) {
                    asistio = true; // Si el empleado asistió, dejamos de buscar
                    break;
                }
            }
            // Verificamos si el empleado está en la lista de retrasos
            if (!asistio) {
                for (Retraso retraso : listaRetrasos) {
                    if (retraso.getEmpleado().equals(empleado)) {
                        asistio = true; // Si el empleado asistió, dejamos de buscar
                        break;
                    }
                }
            }
            if (!asistio) {
                ausentes.add(empleado);
            }
        }
        return ausentes;  // Devolvemos la lista de ausentes
    }


    public List<Retraso> obtenerRetrasos() {
        return listaRetrasos;
    }


    public int obtenerTotalAsistencia() {
        return listaAsistencias.size();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitacion.totalInvitaciones();; //Arreglar esta parte al hacer lista de invitaciones
        if (totalInvitados == 0) {
            return 0.0f;
        }
        return (float) obtenerTotalAsistencia() / totalInvitados * 100;
    }


    public float calcularTiempoReal() { // Calcular la duración real de la reunión, aun no se si esta bien
        if (getHoraFin() != null && getHorarioInicio() != null) {
            Duration duration = Duration.between(getHorarioInicio(), getHoraFin());
            return (float) duration.toMinutes(); // Convertir la duración a minutos
        }
        return 0;
    }


    public void iniciar() {
        this.horarioInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    //Getters y Setters de las propiedades
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
                ", duracion real=" + calcularTiempoReal() + " minutos" +  // Mostramos la duración en minutos
                ", notas=" + nota +
                '}';
    }


}


