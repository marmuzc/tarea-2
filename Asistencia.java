public class Asistencia {
    private Empleado empleado;
    private boolean asistio;
    private Retraso retraso; // Relaciona la clase Retraso

    public Asistencia(Empleado empleado) {
        this.empleado = empleado;
        this.asistio = false; // Inicialmente no ha asistido
        this.retraso = null; // No tiene retraso inicialmente
    }

    // Método para marcar la asistencia
    public void marcarAsistencia(boolean asistio, boolean llegoTarde) {
        this.asistio = asistio;
        if (asistio && llegoTarde) {
            this.retraso = new Retraso(); // Crea un retraso si llega tarde
        }
    }

    public boolean isAsistio() {
        return asistio;
    }

    public boolean tieneRetraso() {
        return retraso != null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "empleado=" + empleado.getNombre() +
                ", asistio=" + asistio +
                ", retraso=" + (retraso != null ? "Sí" : "No") +
                '}';
    }
}
