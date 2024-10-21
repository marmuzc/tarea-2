package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase abstracta que representa una reunión, manejando asistencia,
 * retrasos, ausencias y la duración de la reunión.
 */
abstract class Reunion {
        /** 
     * Fecha en la que se llevará a cabo la reunión. 
     */
    private Date fecha;
    
    /** 
     * Hora prevista de inicio de la reunión. 
     */
    private Instant horaPrevista;
    
    /** 
     * Duración prevista de la reunión. 
     */
    private Duration duracionPrevista;
    
    /** 
     * Hora en la que realmente comenzó la reunión. 
     */
    private Instant horarioInicio;
    
    /** 
     * Hora en la que finalizó la reunión. 
     */
    private Instant horaFin;

    /** 
     * Invitación relacionada con la reunión, que maneja los empleados invitados. 
     */
    protected ListaInvitacion invitacion; // Invitación es parte de Reunión

    /** 
     * Nota opcional que se puede agregar a la reunión, como comentarios o recordatorios.
     */
    private Nota nota;

    /** 
     * Tipo de reunión (técnica, marketing, etc.) definido por una enumeración.
     */
    private tipoReunion tipoReunion;

    /** 
     * Organizador de la reunión, representado por un objeto de la clase Empleado.
     */
    private Empleado organizador;
    
    /** 
     * Lista de asistencias que contiene a los empleados que asistieron a la reunión.
     */
    protected List<Asistencia> listaAsistencias;
    
    /** 
     * Lista de empleados que llegaron tarde a la reunión, registrados como retrasos.
     */
    protected List<Retraso> listaRetrasos;


    /**
     * Constructor para inicializar una reunión con fecha, hora prevista, duración y organizador.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista para el inicio de la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param organizador Organizador de la reunión.
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.invitacion = new ListaInvitacion(horaPrevista); // Composición, se cra invitación dentro de Reunión.
        this.listaAsistencias = new ArrayList<>();
        this.listaRetrasos = new ArrayList<>();
    }

    /**
     * Devuelve el tipo asociado a la reunión.
     * @return El tipo de reunión.
     */
    public tipoReunion getTipo() {
        return tipoReunion;
    }

    /**
     * Establece un tipo de reunión.
     * @param tipoReunion El tipo de la reunión que se va a organizar.
     */
    public void setTipo(tipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    /**
     * Devuelve el Empleado que organiza la reunión.
     * @return el organizador de la reunión.
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    /**
     * Obtiene la nota asociada a la reunión.
     * @return La nota de la reunión.
     */
    public Nota getNota() {
        return nota;
    }

    /**
     * Establece una nota para la reunión.
     * @param nota La nota que se desea asociar.
     */
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    /**
     * Marca la asistencia de un empleado, registrando si llegó a tiempo o con retraso.
     * @param empleado El empleado que asiste a la reunión.
     * @param horaLlegada La hora en que llegó el empleado.
     */
    public void marcarAsistencia(Empleado empleado, Instant horaLlegada) {
        if (invitacion.esInvitado(empleado)) {
            if (horarioInicio != null) {
                if (horaLlegada.isAfter(horarioInicio)) {
                    Retraso retraso = new Retraso(empleado, horaLlegada);
                    listaRetrasos.add(retraso);
                    listaAsistencias.add(retraso);
                } else {
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

    /**
     * Obtiene la lista de asistencias.
     * @return Lista de asistencias.
     */
    public List<Asistencia> obtenerAsistencias() {
        return listaAsistencias;
    }

    /**
     * Obtiene la lista de empleados que no asistieron a la reunión.
     * @return Lista de empleados ausentes.
     */
    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>();
        for (Invitable invitado : invitacion.getInvitados()) {
            Empleado empleado = (Empleado) invitado;
            //Verificamos si el invitado está en la lista de asistencias o de retrasos.
            boolean asistio = listaAsistencias.stream()
                    .anyMatch(asistencia -> asistencia.getEmpleado().equals(empleado)) ||
                    listaRetrasos.stream()
                    .anyMatch(retraso -> retraso.getEmpleado().equals(empleado));
            if (!asistio) {
                ausentes.add(empleado);
            }
        }
        return ausentes;
    }

    /**
     * Obtiene la lista de retrasos registrados en la reunión.
     * @return Lista de retrasos.
     */
    public List<Retraso> obtenerRetrasos() {
        return listaRetrasos;
    }

    /**
     * Obtiene el número total de asistencias a la reunión.
     * @return Número total de asistencias.
     */
    public int obtenerTotalAsistencia() {
        return listaAsistencias.size();
    }

    /**
     * Calcula el porcentaje de asistencia a la reunión.
     * @return Porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitacion.totalInvitaciones();
        if (totalInvitados == 0) {
            return 0.0f;
        }
        return (float) obtenerTotalAsistencia() / totalInvitados * 100;
    }

    /**
     * Calcula el tiempo real de duración de la reunión en minutos.
     * @return Duración real de la reunión en minutos.
     */
    public float calcularTiempoReal() {
        if (getHoraFin() != null && getHorarioInicio() != null) {
            Duration duration = Duration.between(getHorarioInicio(), getHoraFin());
            return (float) duration.toMinutes();
        }
        return 0;
    }

    /**
     * Inicia la reunión estableciendo el horario de inicio.
     */
    public void iniciar() {
        this.horarioInicio = Instant.now();
    }

    /**
     * Finaliza la reunión estableciendo la hora de fin.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }

    /**
     * Obtiene la fecha de la reunión.
     * @return Fecha de la reunión.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reunión.
     * @param fecha La fecha que se desea establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora prevista de la reunión.
     * @return Hora prevista.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Establece la hora prevista de la reunión.
     * @param horaPrevista La hora prevista.
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * Obtiene la duración prevista de la reunión.
     * @return Duración prevista.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Establece la duración prevista de la reunión.
     * @param duracionPrevista La duración prevista.
     */
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Obtiene el horario de inicio de la reunión.
     * @return Horario de inicio.
     */
    public Instant getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * Establece el horario de inicio de la reunión.
     * @param horarioInicio El horario de inicio.
     */
    public void setHorarioInicio(Instant horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * Obtiene la hora de fin de la reunión.
     * @return Hora de fin.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de la reunión.
     * @param horaFin La hora de fin.
     */
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Devuelve una representación en cadena de la reunión, mostrando detalles
     * como fecha, hora prevista, duración, asistencias y retrasos.
     * @return Cadena representativa de la reunión.
     */
    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista.toMinutes() + " minutos" +
                ", horarioInicio=" + horarioInicio +
                ", horaFin=" + horaFin +
                ", organizador= " + organizador +
                ", tipoReunion= " + tipoReunion +
                ", total de asistencias=" + obtenerTotalAsistencia() +
                ", total de ausencias=" + obtenerAusencias().size() +
                ", total de retrasos=" + obtenerRetrasos().size() +
                ", porcentaje de asistencia=" + obtenerPorcentajeAsistencia() + "%" +
                ", duracion real=" + calcularTiempoReal() + " minutos" +
                ", notas=" + nota +
                '}';
    }
}
