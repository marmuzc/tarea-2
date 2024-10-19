import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados; //Agregación de Empleados

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void addEmpleados(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    //Metodo mencionado en UML
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    //Getters y Setters de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Implementacion de Invitable
    @Override
    public void invitar() {
        System.out.println("Se invitó a todos los empleados del departamento " + nombre);
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
