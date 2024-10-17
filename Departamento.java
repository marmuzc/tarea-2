import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void invitar(Invitacion invitacion) {
        System.out.println("Departamento " + nombre + " ha sido invitado a la reunión.");
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", numero de empleados=" + obtenerCantidadEmpleados() +
                '}';
    }
}
