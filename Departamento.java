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

    public void añadirEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void invitar() {
        System.out.println("Invitando a todos los empleados del departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar();
        }
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", numero de empleados=" + obtenerCantidadEmpleados() +
                '}';
    }
}
