import java.time.Instant;

class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada; //agregado para usar en retraso

    public Asistencia(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }
}


