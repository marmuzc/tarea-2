import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horaFin;

    public Reunion() {
    }

    public List obtenerAsistencias() {
        return null;
    }

    public List obtenerAusencias() {
        return null;
    }

    public List obtenerRechazo() {
        return null;
    }

    public int obtenerTotalAsistencia() {
        return 0;
    }

    public float obtenerPorcentajeAsistencia() {
        return 0;
    }

    public float calcularTiempoReal() {
        return 0;
    }

    public void iniciar() {
    }

    public void finalizar() {
    }
}
