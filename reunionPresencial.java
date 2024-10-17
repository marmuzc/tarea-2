import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

class reunionPresencial extends Reunion {
    private String sala;

    public reunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala, Invitacion invitacion, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, invitacion, organizador);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public void iniciar() {
        setHorarioInicio(Instant.now()); // Se marca la hora de inicio
        System.out.println("Reunión presencial iniciada en la sala: " + sala + " a las: " + getHorarioInicio());
    }


    @Override
    public void finalizar() {
        setHoraFin(Instant.now());
        System.out.println("Reunión presencial finalizada en la sala: " + sala + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        return super.toString() + ", sala='" + sala + '\'';
    }

    @Override
    public List<Empleado> obtenerAsistencias() {
        return super.obtenerAsistencias();
    }

    @Override
    public List<Empleado> obtenerAusencias() {
        return super.obtenerAusencias();
    }

    @Override
    public List<Empleado> obtenerRetrasos() {
        return super.obtenerRetrasos();
    } //necesitamos agregar la hora de llegada de los que llegan tarde

    @Override
    public int obtenerTotalAsistencia() {
        return super.obtenerTotalAsistencia();
    }

    public float obtenerPorcentajeAsistencia() {
        return super.obtenerPorcentajeAsistencia();
    }


}
