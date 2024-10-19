public class Asistencia {
    private Empleado empleado; //Asociacion con Empleado

    public Asistencia(Empleado empleado) {
        this.empleado = empleado;
    }

    //Getter de empleado
    public Empleado getEmpleado() {
        return empleado;
    }
}
