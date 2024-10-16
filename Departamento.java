import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre; // Debe estar fuera del bloque de inicialización
    private List<Empleado> empleados; // Debe estar fuera del bloque de inicialización

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>(); // Inicializa la lista de empleados
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public void añadirEmpleado(Empleado empleado) { // Cambié "añadirEmpleados" a "añadirEmpleado" para que sea más claro
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
        // Lógica para invitar a todos los empleados del departamento
        System.out.println("Invitando a todos los empleados del departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(); // Asumiendo que el método invitar() está implementado en Empleado
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
