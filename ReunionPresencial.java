import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

class reunionPresencial extends Reunion {
    private String sala;

<<<<<<< HEAD:reunionPresencial.java
    public reunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala, Invitacion invitacion, Empleado organizador) {
        super(fecha, horaPrevista, duracionPrevista, invitacion, organizador);
=======
    public reunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala) {
        super(fecha, horaPrevista, duracionPrevista);
>>>>>>> test-new-logic:ReunionPresencial.java
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
        super.iniciar(); // Llamamos al método de la clase padre para registrar la hora de inicio
        System.out.println("Reunión presencial iniciada en la sala: " + sala + " a las: " + getHorarioInicio());
    }

    @Override
    public void finalizar() {
        super.finalizar(); // Llamamos al método de la clase padre para registrar la hora de fin
        System.out.println("Reunión presencial finalizada en la sala: " + sala + " a las: " + getHoraFin());
    }

    @Override
    public String toString() {
        // Llamamos al toString() de la clase padre y agregamos la información adicional de la sala
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
